package br.com.denisecastro.androidrunner.data.highscore.repository

import br.com.denisecastro.androidrunner.data.highscore.local.HighScoreDataStore
import br.com.denisecastro.androidrunner.domain.highscore.repository.HighScoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HighScoreRepositoryImpl @Inject constructor(
    private val dataStore: HighScoreDataStore
) : HighScoreRepository {

    override val highScore: Flow<Int>
        get() = dataStore.highScore

    override suspend fun saveHighScore(highScore: Int) {
        dataStore.saveHighScore(highScore)
    }
}