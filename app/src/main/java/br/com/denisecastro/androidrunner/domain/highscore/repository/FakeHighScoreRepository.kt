package br.com.denisecastro.androidrunner.domain.highscore.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.Flow

class FakeHighScoreRepository : HighScoreRepository {

    private val _highScore = MutableStateFlow(0)

    override val highScore: Flow<Int> = _highScore

    override suspend fun saveHighScore(highScore: Int) {
        _highScore.value = highScore
    }
}
