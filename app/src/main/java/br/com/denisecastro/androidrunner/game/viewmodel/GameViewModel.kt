package br.com.denisecastro.androidrunner.game.viewmodel

import androidx.lifecycle.ViewModel
import br.com.denisecastro.androidrunner.game.engine.CollisionDetector
import br.com.denisecastro.androidrunner.game.engine.GameConstants
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

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        GameUiState(
            obstacles = listOf(
                Obstacle(
                    id = 1L,
                    x = GameConstants.INITIAL_OBSTACLE_X,
                    width = GameConstants.OBSTACLE_WIDTH,
                    height = GameConstants.OBSTACLE_HEIGHT
                )
            )
        )
    )

    private var obstacleSpawnTimer = 0f
    private var nextObstacleId = 2L

    val uiState: StateFlow<GameUiState> =
        _uiState.asStateFlow()

    fun onEvent(event: GameUiEvent) {
        when (event) {
            GameUiEvent.JumpClicked -> jump()
            GameUiEvent.PauseClicked -> togglePause()
        }
    }

    private fun jump() {
        _uiState.update { state ->
            if (state.isJumping || state.isPaused) {
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

    fun updateGame(deltaTimeSeconds: Float) {
        val currentState = _uiState.value
        if (
            currentState.isPaused ||
            currentState.isGameOver
        ) {
            return
        }

        val physicsState = GamePhysics.updatePlayer(
            y = currentState.playerY,
            velocityY = currentState.playerVelocityY,
            deltaTimeSeconds = deltaTimeSeconds
        )

        val updatedObstacles = currentState.obstacles
            .map { obstacle ->
                ObstaclePhysics.update(
                    obstacle = obstacle,
                    deltaTimeSeconds = deltaTimeSeconds
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

        _uiState.update { state ->
            state.copy(
                playerY = physicsState.y,
                playerVelocityY = physicsState.velocityY,
                isJumping = physicsState.isJumping,
                obstacles = updatedObstacles,
                isGameOver = hasCollision
            )
        }
    }
}