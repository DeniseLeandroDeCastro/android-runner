package br.com.denisecastro.androidrunner.game.engine

import br.com.denisecastro.androidrunner.game.engine.constants.GameConstants
import br.com.denisecastro.androidrunner.game.model.Obstacle
import br.com.denisecastro.androidrunner.game.model.ObstacleType
import kotlin.random.Random

object ObstacleSpawner {

    fun create(
        id: Long,
        startX: Float = GameConstants.INITIAL_OBSTACLE_X
    ): Obstacle {

        val type = ObstacleType.entries.random()

        val (width, height) = when (Random.nextInt(3)) {

            0 -> {
                GameConstants.SMALL_OBSTACLE_WIDTH to
                        GameConstants.SMALL_OBSTACLE_HEIGHT
            }

            1 -> {
                GameConstants.OBSTACLE_WIDTH to
                        GameConstants.OBSTACLE_HEIGHT
            }

            else -> {
                GameConstants.LARGE_OBSTACLE_WIDTH to
                        GameConstants.LARGE_OBSTACLE_HEIGHT
            }
        }

        return Obstacle(
            id = id,
            x = startX,
            width = width,
            height = height,
            type = type
        )
    }
}