package br.com.denisecastro.androidrunner.game.engine

import br.com.denisecastro.androidrunner.game.engine.constants.GameConstants
import br.com.denisecastro.androidrunner.game.model.HitBox

object CollisionDetector {
    fun collides(
        first: HitBox,
        second: HitBox
    ): Boolean {
        return first.left < second.right &&
                first.right > second.left &&
                first.top < second.bottom &&
                first.bottom > second.top
    }

    fun playerHitBox(
        playerY: Float
    ): HitBox {

        val bottom = GameConstants.GROUND_Y + playerY

        return HitBox(
            left = GameConstants.PLAYER_X,
            top = bottom - GameConstants.PLAYER_HITBOX_HEIGHT,
            right = GameConstants.PLAYER_X +
                    GameConstants.PLAYER_HITBOX_WIDTH,
            bottom = bottom
        )
    }

    fun obstacleHitBox(
        x: Float,
        width: Float,
        height: Float
    ): HitBox {
        return HitBox(
            left = x,
            top = GameConstants.GROUND_Y - height,
            right = x + width,
            bottom = GameConstants.GROUND_Y
        )
    }

    fun collectibleHitBox(
        x: Float,
        y: Float,
        size: Float
    ): HitBox {
        return HitBox(
            left = x,
            top = GameConstants.GROUND_Y - y - size,
            right = x + size,
            bottom = GameConstants.GROUND_Y - y
        )
    }
}