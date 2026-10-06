package br.com.denisecastro.androidrunner.game.engine

import br.com.denisecastro.androidrunner.game.model.Obstacle

object ObstaclePhysics {

    fun update(
        obstacle: Obstacle,
        deltaTimeSeconds: Float,
        speed: Float
    ): Obstacle {

        val newX = obstacle.x - speed * deltaTimeSeconds

        return obstacle.copy(
            x = newX
        )
    }
}