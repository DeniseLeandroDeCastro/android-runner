package br.com.denisecastro.androidrunner.game.model

data class Obstacle(
    val id: Long,
    val x: Float,
    val width: Float,
    val height: Float,
    val type: ObstacleType
)