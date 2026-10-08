package br.com.denisecastro.androidrunner.game.engine


import br.com.denisecastro.androidrunner.game.model.Collectible
import br.com.denisecastro.androidrunner.game.model.CollectibleType

object CollectibleSpawner {

    fun create(
        id: Long,
        startX: Float = 420f
    ): Collectible {

        val type = listOf(
            CollectibleType.ANDROID_COIN,
            CollectibleType.ANDROID_COIN,
            CollectibleType.ANDROID_COIN,
            CollectibleType.CODE_TOKEN,
            CollectibleType.CODE_TOKEN,
            CollectibleType.DATA_CHIP,
            CollectibleType.DATA_CHIP,
            CollectibleType.KOTLIN_GEM,
            CollectibleType.ENERGY_BOLT,
            CollectibleType.ENERGY_BOLT,
            CollectibleType.BUG_FIX,
            CollectibleType.BATTERY,
            CollectibleType.STAR_XP
        ).random()
        return Collectible(
            id = id,
            x = startX,
            y = listOf(20f, 60f, 100f).random(),
            size = 64f,
            type = type
        )
    }
}