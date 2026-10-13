
package br.com.denisecastro.androidrunner.game.engine

import br.com.denisecastro.androidrunner.game.engine.constants.GameConstants
import br.com.denisecastro.androidrunner.game.model.HitBox
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.Assert.assertEquals

class CollisionDetectorTest {

    @Test
    fun `should detect collision when hitboxes overlap`() {

        // Arrange
        val playerHitBox = HitBox(
            left = 70f,
            top = -75f,
            right = 125f,
            bottom = 0f
        )

        val obstacleHitBox = HitBox(
            left = 100f,
            top = -70f,
            right = 155f,
            bottom = 0f
        )

        // Act
        val result = CollisionDetector.collides(
            first = playerHitBox,
            second = obstacleHitBox
        )

        // Assert
        assertTrue(result)
    }


    @Test
    fun `should not detect collision when hitboxes do not overlap`() {

        // Arrange
        val playerHitBox = HitBox(
            left = 70f,
            top = -75f,
            right = 125f,
            bottom = 0f
        )

        val obstacleHitBox = HitBox(
            left = 200f,
            top = -70f,
            right = 255f,
            bottom = 0f
        )

        // Act
        val result = CollisionDetector.collides(
            first = playerHitBox,
            second = obstacleHitBox
        )

        // Assert
        assertFalse(result)
    }


    @Test
    fun `should not collide when player jumps over obstacle`() {

        // Arrange
        val playerY = -150f

        val playerHitBox = CollisionDetector.playerHitBox(
            playerY = playerY
        )

        val obstacleHitBox = CollisionDetector.obstacleHitBox(
            x = GameConstants.PLAYER_X,
            width = 55f,
            height = 70f
        )

        // Act
        val result = CollisionDetector.collides(
            first = playerHitBox,
            second = obstacleHitBox
        )

        // Assert
        assertFalse(result)
    }


    @Test
    fun `should calculate collectible hitbox correctly`() {

        // Arrange
        val x = 100f
        val y = 50f
        val size = 30f

        // Act
        val result = CollisionDetector.collectibleHitBox(
            x = x,
            y = y,
            size = size
        )

        // Assert
        assertEquals(100f, result.left, 0.001f)
        assertEquals(-80f, result.top, 0.001f)
        assertEquals(130f, result.right, 0.001f)
        assertEquals(-50f, result.bottom, 0.001f)
    }


    @Test
    fun `should detect collision when player touches collectible`() {

        // Arrange
        val playerHitBox = CollisionDetector.playerHitBox(
            playerY = 0f
        )

        val collectibleHitBox = CollisionDetector.collectibleHitBox(
            x = GameConstants.PLAYER_X + 20f,
            y = 30f,
            size = 40f
        )

        // Act
        val result = CollisionDetector.collides(
            first = playerHitBox,
            second = collectibleHitBox
        )

        // Assert
        assertTrue(result)
    }
}
