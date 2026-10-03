package br.com.denisecastro.androidrunner.game.engine

import br.com.denisecastro.androidrunner.game.engine.constants.GameConstants
import br.com.denisecastro.androidrunner.game.model.Obstacle

object ObstaclePhysics {
    fun update(
        obstacle: Obstacle,
        deltaTimeSeconds: Float
    ): Obstacle {
        val newX =
            obstacle.x - GameConstants.OBSTACLE_SPEED * deltaTimeSeconds

        return obstacle.copy(
            x = newX
        )
    }
}