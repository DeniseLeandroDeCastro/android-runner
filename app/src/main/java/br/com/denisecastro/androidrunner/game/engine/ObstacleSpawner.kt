package br.com.denisecastro.androidrunner.game.engine

import br.com.denisecastro.androidrunner.game.model.Obstacle

object ObstacleSpawner {
    fun create(
        id: Long,
        startX: Float = GameConstants.INITIAL_OBSTACLE_X
    ): Obstacle {
        return Obstacle(
            id = id,
            x = startX,
            width = GameConstants.OBSTACLE_WIDTH,
            height = GameConstants.OBSTACLE_HEIGHT
        )
    }
}
