package br.com.denisecastro.androidrunner.game.viewmodel

import androidx.lifecycle.ViewModel
import br.com.denisecastro.androidrunner.game.engine.GameConstants
import br.com.denisecastro.androidrunner.game.engine.GamePhysics
import br.com.denisecastro.androidrunner.game.events.GameUiEvent
import br.com.denisecastro.androidrunner.game.state.GameUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        GameUiState()
    )

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

        if (currentState.isPaused) {
            return
        }

        val physicsState = GamePhysics.updatePlayer(
            y = currentState.playerY,
            velocityY = currentState.playerVelocityY,
            deltaTimeSeconds = deltaTimeSeconds
        )

        _uiState.update { state ->
            state.copy(
                playerY = physicsState.y,
                playerVelocityY = physicsState.velocityY,
                isJumping = physicsState.isJumping
            )
        }
    }
}