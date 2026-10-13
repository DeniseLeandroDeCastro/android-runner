
package br.com.denisecastro.androidrunner.game.model

import org.junit.Assert.assertEquals
import org.junit.Test

class CollectibleTypeTest {

    @Test
    fun `should return correct points for each collectible type`() {

        // Arrange
        val expectedPoints = mapOf(
            CollectibleType.ANDROID_COIN to 100,
            CollectibleType.CODE_TOKEN to 150,
            CollectibleType.DATA_CHIP to 200,
            CollectibleType.KOTLIN_GEM to 300,
            CollectibleType.ENERGY_BOLT to 150,
            CollectibleType.BUG_FIX to 250,
            CollectibleType.BATTERY to 200,
            CollectibleType.STAR_XP to 500
        )

        // Act e Assert
        expectedPoints.forEach { (type, points) ->
            assertEquals(
                "Pontuação incorreta para $type",
                points,
                type.points
            )
        }
    }
}
