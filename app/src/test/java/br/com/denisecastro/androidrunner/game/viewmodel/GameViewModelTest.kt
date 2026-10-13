
package br.com.denisecastro.androidrunner.game.viewmodel

import br.com.denisecastro.androidrunner.data.ranking.repository.FakeRankingRepository
import br.com.denisecastro.androidrunner.domain.highscore.repository.FakeHighScoreRepository
import br.com.denisecastro.androidrunner.domain.settings.repository.FakeSettingsRepository
import br.com.denisecastro.androidrunner.game.events.GameUiEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.resetMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import br.com.denisecastro.androidrunner.game.engine.constants.GameConstants

@OptIn(ExperimentalCoroutinesApi::class)
class GameViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var viewModel: GameViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        viewModel = GameViewModel(
            highScoreRepository = FakeHighScoreRepository(),
            rankingRepository = FakeRankingRepository(),
            settingsRepository = FakeSettingsRepository()
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }


    @Test
    fun `should start game with zero score`() {

        // Arrange
        val initialState = viewModel.uiState.value

        // Assert
        assertEquals(0, initialState.score)
    }


    @Test
    fun `should increase score as game time passes`() {

        // Arrange
        val initialScore = viewModel.uiState.value.score

        // Act
        viewModel.updateGame(
            deltaTimeSeconds = 0.5f
        )

        // Assert
        val updatedScore = viewModel.uiState.value.score

        assertEquals(0, initialScore)
        assertEquals(50, updatedScore)
    }


    @Test
    fun `should not increase score when game is paused`() {

        // Arrange
        viewModel.updateGame(
            deltaTimeSeconds = 0.5f
        )

        val scoreBeforePause = viewModel.uiState.value.score

        // Act
        viewModel.onEvent(GameUiEvent.PauseClicked)

        viewModel.updateGame(
            deltaTimeSeconds = 1f
        )

        // Assert
        val scoreAfterPause = viewModel.uiState.value.score

        assertEquals(50, scoreBeforePause)
        assertEquals(scoreBeforePause, scoreAfterPause)
    }


    @Test
    fun `should resume scoring after game is unpaused`() {

        // Arrange
        viewModel.updateGame(
            deltaTimeSeconds = 0.5f
        )

        viewModel.onEvent(GameUiEvent.PauseClicked)

        // Act
        viewModel.onEvent(GameUiEvent.PauseClicked)

        viewModel.updateGame(
            deltaTimeSeconds = 0.5f
        )

        // Assert
        val updatedState = viewModel.uiState.value

        assertEquals(100, updatedState.score)
        assertFalse(updatedState.isPaused)
    }


    @Test
    fun `should reset score when game restarts`() {

        // Arrange
        viewModel.updateGame(
            deltaTimeSeconds = 0.5f
        )

        val scoreBeforeRestart = viewModel.uiState.value.score

        // Act
        viewModel.onEvent(GameUiEvent.RestartClicked)

        // Assert
        val stateAfterRestart = viewModel.uiState.value

        assertEquals(50, scoreBeforeRestart)
        assertEquals(0, stateAfterRestart.score)
        assertFalse(stateAfterRestart.isGameOver)
        assertFalse(stateAfterRestart.isPaused)
    }


    @Test
    fun `should start jumping when jump is clicked`() {

        // Arrange
        val initialState = viewModel.uiState.value

        assertFalse(initialState.isJumping)

        // Act
        viewModel.onEvent(GameUiEvent.JumpClicked)

        // Assert
        val updatedState = viewModel.uiState.value

        assertTrue(updatedState.isJumping)

        assertEquals(
            GameConstants.JUMP_VELOCITY,
            updatedState.playerVelocityY,
            0.001f
        )
    }


    @Test
    fun `should not jump again while already jumping`() {

        // Arrange
        viewModel.onEvent(GameUiEvent.JumpClicked)

        val firstJumpState = viewModel.uiState.value

        // Act
        viewModel.onEvent(GameUiEvent.JumpClicked)

        // Assert
        val secondJumpState = viewModel.uiState.value

        assertTrue(secondJumpState.isJumping)

        assertEquals(
            firstJumpState.playerVelocityY,
            secondJumpState.playerVelocityY,
            0.001f
        )
    }


    @Test
    fun `should not jump when game is paused`() {

        // Arrange
        viewModel.onEvent(GameUiEvent.PauseClicked)

        val stateBeforeJump = viewModel.uiState.value

        // Act
        viewModel.onEvent(GameUiEvent.JumpClicked)

        // Assert
        val stateAfterJump = viewModel.uiState.value

        assertTrue(stateAfterJump.isPaused)
        assertFalse(stateAfterJump.isJumping)

        assertEquals(
            stateBeforeJump.playerVelocityY,
            stateAfterJump.playerVelocityY,
            0.001f
        )
    }


    @Test
    fun `should not jump when game is over`() {

        // Arrange
        viewModel.updateGame(
            deltaTimeSeconds = 2f
        )

        val stateBeforeJump = viewModel.uiState.value

        assertTrue(stateBeforeJump.isGameOver)

        // Act
        viewModel.onEvent(GameUiEvent.JumpClicked)

        // Assert
        val stateAfterJump = viewModel.uiState.value

        assertTrue(stateAfterJump.isGameOver)
        assertFalse(stateAfterJump.isJumping)

        assertEquals(
            stateBeforeJump.playerVelocityY,
            stateAfterJump.playerVelocityY,
            0.001f
        )
    }


    @Test
    fun `should not increase score after game over`() {

        // Arrange
        viewModel.updateGame(
            deltaTimeSeconds = 2f
        )

        val stateAfterGameOver = viewModel.uiState.value

        assertTrue(stateAfterGameOver.isGameOver)

        val scoreBefore = stateAfterGameOver.score

        // Act
        viewModel.updateGame(
            deltaTimeSeconds = 1f
        )

        // Assert
        val stateAfterUpdate = viewModel.uiState.value

        assertTrue(stateAfterUpdate.isGameOver)

        assertEquals(
            scoreBefore,
            stateAfterUpdate.score
        )
    }


    @Test
    fun `should preserve high score when game restarts`() {

        // Arrange
        viewModel.updateGame(
            deltaTimeSeconds = 2f
        )

        val stateBeforeRestart = viewModel.uiState.value

        assertTrue(stateBeforeRestart.isGameOver)

        val highScoreBeforeRestart = stateBeforeRestart.highScore

        // Act
        viewModel.onEvent(GameUiEvent.RestartClicked)

        // Assert
        val stateAfterRestart = viewModel.uiState.value

        assertEquals(
            highScoreBeforeRestart,
            stateAfterRestart.highScore
        )

        assertEquals(0, stateAfterRestart.score)
        assertFalse(stateAfterRestart.isGameOver)
    }
}
