package br.com.denisecastro.androidrunner.data.ranking.repository

import kotlinx.coroutines.flow.Flow

interface RankingRepository {

    fun observeTopScores(
        limit: Int
    ): Flow<List<Int>>

    suspend fun saveScore(
        score: Int
    )
}