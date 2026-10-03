package br.com.denisecastro.androidrunner.domain.highscore.repository

import kotlinx.coroutines.flow.Flow

interface HighScoreRepository {

    val highScore: Flow<Int>

    suspend fun saveHighScore(highScore: Int)
}