package br.com.denisecastro.androidrunner.game.engine

import br.com.denisecastro.androidrunner.game.model.Collectible

object CollectiblePhysics {

    fun update(
        collectible: Collectible,
        deltaTimeSeconds: Float,
        speed: Float
    ): Collectible {

        val newX =
            collectible.x - speed * deltaTimeSeconds

        return collectible.copy(
            x = newX
        )
    }
}