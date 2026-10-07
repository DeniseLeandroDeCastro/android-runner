package br.com.denisecastro.androidrunner.game.model

data class Collectible(
    val id: Long,
    val x: Float,
    val y: Float,
    val size: Float,
    val type: CollectibleType
)
