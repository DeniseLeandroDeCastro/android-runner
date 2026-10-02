package br.com.denisecastro.androidrunner.game.engine

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
}