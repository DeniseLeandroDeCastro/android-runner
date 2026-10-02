package br.com.denisecastro.androidrunner.game.engine

data class PlayerPhysicsState(
    val y: Float,
    val velocityY: Float,
    val isJumping: Boolean
)

object GamePhysics {
    fun updatePlayer(
        y: Float,
        velocityY: Float,
        deltaTimeSeconds: Float
    ): PlayerPhysicsState {

        val newVelocityY =
            velocityY + GameConstants.GRAVITY * deltaTimeSeconds

        val newY =
            y + newVelocityY * deltaTimeSeconds

        return if (newY >= GameConstants.GROUND_Y) {

            PlayerPhysicsState(
                y = GameConstants.GROUND_Y,
                velocityY = 0f,
                isJumping = false
            )

        } else {

            PlayerPhysicsState(
                y = newY,
                velocityY = newVelocityY,
                isJumping = true
            )
        }
    }
}