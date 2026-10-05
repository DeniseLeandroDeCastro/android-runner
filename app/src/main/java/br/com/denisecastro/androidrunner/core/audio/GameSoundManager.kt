package br.com.denisecastro.androidrunner.core.audio

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import br.com.denisecastro.androidrunner.R

class GameSoundManager(
    context: Context
) {

    private val soundPool: SoundPool

    private val jumpSoundId: Int
    private val gameOverSoundId: Int

    init {
        val audioAttributes =
            AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(
                    AudioAttributes.CONTENT_TYPE_SONIFICATION
                )
                .build()

        soundPool =
            SoundPool.Builder()
                .setMaxStreams(2)
                .setAudioAttributes(audioAttributes)
                .build()

        jumpSoundId =
            soundPool.load(
                context,
                R.raw.jump,
                1
            )

        gameOverSoundId =
            soundPool.load(
                context,
                R.raw.game_over,
                1
            )
    }

    fun playJump() {
        play(jumpSoundId)
    }

    fun playGameOver() {
        play(gameOverSoundId)
    }

    private fun play(soundId: Int) {
        soundPool.play(
            soundId,
            1f,
            1f,
            1,
            0,
            1f
        )
    }

    fun release() {
        soundPool.release()
    }
}