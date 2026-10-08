package br.com.denisecastro.androidrunner.game.engine


import br.com.denisecastro.androidrunner.game.model.Collectible
import br.com.denisecastro.androidrunner.game.model.CollectibleType

object CollectibleSpawner {

    fun create(
        id: Long,
        startX: Float = 420f
    ): Collectible {

        val totalWeight = CollectibleType.entries.sumOf { it.weight }

        val randomWeight = (1..totalWeight).random()

        var accumulatedWeight = 0

        val type = CollectibleType.entries.first { collectibleType ->
            accumulatedWeight += collectibleType.weight
            randomWeight <= accumulatedWeight
        }
        return Collectible(
            id = id,
            x = startX,
            y = listOf(20f, 60f, 100f).random(),
            size = 64f,
            type = type
        )
    }
}