package br.com.denisecastro.androidrunner.game.viewmodel

import androidx.lifecycle.ViewModel
import br.com.denisecastro.androidrunner.game.engine.CollisionDetector
import br.com.denisecastro.androidrunner.game.engine.constants.GameConstants
import br.com.denisecastro.androidrunner.game.engine.GamePhysics
import br.com.denisecastro.androidrunner.game.engine.ObstaclePhysics
import br.com.denisecastro.androidrunner.game.engine.ObstacleSpawner
import br.com.denisecastro.androidrunner.game.events.GameUiEvent
import br.com.denisecastro.androidrunner.game.model.Obstacle
import br.com.denisecastro.androidrunner.game.state.GameUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import androidx.lifecycle.viewModelScope
import br.com.denisecastro.androidrunner.data.ranking.repository.RankingRepository
import br.com.denisecastro.androidrunner.domain.highscore.repository.HighScoreRepository
import br.com.denisecastro.androidrunner.domain.settings.repository.SettingsRepository
import br.com.denisecastro.androidrunner.game.model.ObstacleType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val highScoreRepository: HighScoreRepository,
    private val rankingRepository: RankingRepository,
    private val settingsRepository: SettingsRepository
) : ViewModel() {
    private var obstacleSpawnTimer = 0f
    private var nextObstacleId = 2L
    private var elapsedGameTime = 0f
    private val _uiState = MutableStateFlow(
        GameUiState(
            obstacles = listOf(
                Obstacle(
                    id = 1L,
                    x = GameConstants.INITIAL_OBSTACLE_X,
                    width = GameConstants.OBSTACLE_WIDTH,
                    height = GameConstants.OBSTACLE_HEIGHT,
                    type = ObstacleType.BARRIER
                )
            )
        )
    )

    init {
        observeHighScore()
        observeSettings()
    }

    private fun observeHighScore() {
        viewModelScope.launch {
            highScoreRepository.highScore.collect { highScore ->
                _uiState.update { state ->
                    state.copy(
                        highScore = highScore
                    )
                }
            }
        }
    }

    private fun restartGame() {
        val currentState = _uiState.value

        obstacleSpawnTimer = 0f
        nextObstacleId = 2L
        elapsedGameTime = 0f

        _uiState.value = GameUiState(
            highScore = currentState.highScore,
            vibrationEnabled = currentState.vibrationEnabled,
            soundEnabled = currentState.soundEnabled,
            obstacles = listOf(
                ObstacleSpawner.create(
                    id = 1L
                )
            )
        )
    }

    private fun saveHighScore(score: Int) {
        viewModelScope.launch {
            highScoreRepository.saveHighScore(score)
        }
    }

    private fun saveScoreToRanking(score: Int) {
        viewModelScope.launch {
            rankingRepository.saveScore(score)
        }
    }

    val uiState: StateFlow<GameUiState> =
        _uiState.asStateFlow()

    fun onEvent(event: GameUiEvent) {
        when (event) {
            GameUiEvent.JumpClicked -> jump()
            GameUiEvent.PauseClicked -> togglePause()
            GameUiEvent.RestartClicked -> restartGame()
            GameUiEvent.HomeClicked -> Unit
        }
    }

    private fun jump() {
        _uiState.update { state ->
            if (
                state.isJumping ||
                state.isPaused ||
                state.isGameOver
            ) {
                return@update state
            }

            state.copy(
                playerVelocityY = GameConstants.JUMP_VELOCITY,
                isJumping = true
            )
        }
    }

    private fun togglePause() {
        _uiState.update { state ->
            state.copy(
                isPaused = !state.isPaused
            )
        }
    }

    private fun observeSettings() {
        viewModelScope.launch {
            settingsRepository.settings.collect { settings ->
                _uiState.update { state ->
                    state.copy(
                        vibrationEnabled = settings.vibrationEnabled,
                        soundEnabled = settings.soundEnabled
                    )
                }
            }
        }
    }

    fun updateGame(deltaTimeSeconds: Float) {
        val currentState = _uiState.value
        if (
            currentState.isPaused ||
            currentState.isGameOver
        ) {
            return
        }
        elapsedGameTime += deltaTimeSeconds

        val updatedScore =
            (elapsedGameTime * GameConstants.SCORE_PER_SECOND)
                .toInt()

        val physicsState = GamePhysics.updatePlayer(
            y = currentState.playerY,
            velocityY = currentState.playerVelocityY,
            deltaTimeSeconds = deltaTimeSeconds
        )

        val speedLevel = currentState.score / 1000

        val obstacleSpeed = (
                GameConstants.INITIAL_OBSTACLE_SPEED +
                        speedLevel * GameConstants.SPEED_INCREASE_PER_1000_POINTS
                ).coerceAtMost(GameConstants.MAX_OBSTACLE_SPEED)

        val updatedObstacles = currentState.obstacles
            .map { obstacle ->
                ObstaclePhysics.update(
                    obstacle = obstacle,
                    deltaTimeSeconds = deltaTimeSeconds,
                    speed = obstacleSpeed
                )
            }
            .filter { obstacle ->
                obstacle.x > GameConstants.OBSTACLE_REMOVE_X
            }
            .toMutableList()
        obstacleSpawnTimer += deltaTimeSeconds
        if (
            obstacleSpawnTimer >=
            GameConstants.OBSTACLE_SPAWN_INTERVAL
        ) {
            updatedObstacles.add(
                ObstacleSpawner.create(
                    id = nextObstacleId++
                )
            )
            obstacleSpawnTimer = 0f
        }

        val playerHitBox = CollisionDetector.playerHitBox(
            playerY = physicsState.y
        )

        val hasCollision = updatedObstacles.any { obstacle ->
            val obstacleHitBox =
                CollisionDetector.obstacleHitBox(
                    x = obstacle.x,
                    width = obstacle.width,
                    height = obstacle.height
                )
            CollisionDetector.collides(
                first = playerHitBox,
                second = obstacleHitBox
            )
        }

        val updatedHighScore =
            if (hasCollision) {
                maxOf(
                    currentState.highScore,
                    updatedScore
                )
            } else {
                currentState.highScore
            }

        if (hasCollision) {
            saveScoreToRanking(updatedScore)
        }

        if (
            hasCollision &&
            updatedScore > currentState.highScore
        ) {
            saveHighScore(updatedScore)
        }

        _uiState.update { state ->
            state.copy(
                score = updatedScore,
                highScore = updatedHighScore,
                playerY = physicsState.y,
                playerVelocityY = physicsState.velocityY,
                isJumping = physicsState.isJumping,
                obstacles = updatedObstacles,
                isGameOver = hasCollision
            )
        }
    }
}