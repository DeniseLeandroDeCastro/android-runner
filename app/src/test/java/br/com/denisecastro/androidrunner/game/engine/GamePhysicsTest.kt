
package br.com.denisecastro.androidrunner.game.engine

import br.com.denisecastro.androidrunner.game.engine.constants.GameConstants
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test
import org.junit.Assert.assertTrue

class GamePhysicsTest {

    @Test
    fun `player should remain on ground when not jumping`() {

        // Arrange
        val initialY = GameConstants.GROUND_Y
        val initialVelocityY = 0f
        val deltaTimeSeconds = 0.016f

        // Act
        val result = GamePhysics.updatePlayer(
            y = initialY,
            velocityY = initialVelocityY,
            deltaTimeSeconds = deltaTimeSeconds
        )

        // Assert
        assertEquals(
            GameConstants.GROUND_Y,
            result.y,
            0.001f
        )

        assertEquals(
            0f,
            result.velocityY,
            0.001f
        )

        assertFalse(result.isJumping)
    }


    @Test
    fun `player should move upward when jumping`() {

        // Arrange
        val initialY = GameConstants.GROUND_Y
        val initialVelocityY = GameConstants.JUMP_VELOCITY
        val deltaTimeSeconds = 0.016f

        // Act
        val result = GamePhysics.updatePlayer(
            y = initialY,
            velocityY = initialVelocityY,
            deltaTimeSeconds = deltaTimeSeconds
        )

        // Assert
        assertTrue(result.y < GameConstants.GROUND_Y)

        assertTrue(result.velocityY < 0f)

        assertTrue(result.isJumping)
    }


    @Test
    fun `player should land on ground after falling`() {

        // Arrange
        val initialY = -5f
        val initialVelocityY = 500f
        val deltaTimeSeconds = 0.016f

        // Act
        val result = GamePhysics.updatePlayer(
            y = initialY,
            velocityY = initialVelocityY,
            deltaTimeSeconds = deltaTimeSeconds
        )

        // Assert
        assertEquals(
            GameConstants.GROUND_Y,
            result.y,
            0.001f
        )

        assertEquals(
            0f,
            result.velocityY,
            0.001f
        )

        assertFalse(result.isJumping)
    }

}
