package br.com.denisecastro.androidrunner.game.engine


import br.com.denisecastro.androidrunner.game.model.Collectible
import br.com.denisecastro.androidrunner.game.model.CollectibleType
import kotlin.random.Random

object CollectibleSpawner {

    fun create(
        id: Long,
        startX: Float = 420f
    ): Collectible {

        val type = CollectibleType.entries.random()

        return Collectible(
            id = id,
            x = startX,
            y = Random.nextFloat() * 100f,
            size = 64f,
            type = type
        )
    }
}