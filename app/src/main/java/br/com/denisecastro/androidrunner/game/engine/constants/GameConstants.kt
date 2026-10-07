package br.com.denisecastro.androidrunner.game.engine.constants

object GameConstants {
    const val GRAVITY = 2200f
    const val JUMP_VELOCITY = -1050f
    const val GROUND_Y = 0f

    // Obstacles
    const val INITIAL_OBSTACLE_X = 420f
    const val INITIAL_OBSTACLE_SPEED = 180f
    const val MAX_OBSTACLE_SPEED = 360f
    const val SPEED_INCREASE_PER_1000_POINTS = 20f
    const val OBSTACLE_WIDTH = 55f
    const val OBSTACLE_HEIGHT = 70f
    const val SMALL_OBSTACLE_WIDTH = 45f
    const val SMALL_OBSTACLE_HEIGHT = 50f
    const val LARGE_OBSTACLE_WIDTH = 65f
    const val LARGE_OBSTACLE_HEIGHT = 85f
    const val OBSTACLE_SPAWN_INTERVAL = 2.5f
    const val OBSTACLE_REMOVE_X = -100f
    const val PLAYER_X = 70f
    const val PLAYER_HITBOX_WIDTH = 55f
    const val PLAYER_HITBOX_HEIGHT = 75f
    const val SCORE_PER_SECOND = 100
    const val COLLECTIBLE_SPAWN_INTERVAL = 3f
    const val COLLECTIBLE_START_X = 420f
    const val COLLECTIBLE_SAFE_DISTANCE = 100f
}