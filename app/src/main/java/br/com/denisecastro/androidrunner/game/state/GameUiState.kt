package br.com.denisecastro.androidrunner.game.state

data class GameUiState(
    val score: Int = 0,
    val isPaused: Boolean = false,
    val playerY: Float = 0f,
    val playerVelocityY: Float = 0f,
    val isJumping: Boolean = false
)