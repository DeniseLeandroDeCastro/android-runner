package br.com.denisecastro.androidrunner.game.state

import br.com.denisecastro.androidrunner.game.model.Obstacle
import br.com.denisecastro.androidrunner.game.model.Collectible

data class GameUiState(
    val score: Int = 0,
    val highScore: Int = 0,
    val isPaused: Boolean = false,
    val playerY: Float = 0f,
    val playerVelocityY: Float = 0f,
    val isJumping: Boolean = false,
    val obstacles: List<Obstacle> = emptyList(),
    val collectibles: List<Collectible> = emptyList(),
    val collectedPointsFeedback: Int? = null,
    val isGameOver: Boolean = false,
    val vibrationEnabled: Boolean = true,
    val soundEnabled: Boolean = true
)