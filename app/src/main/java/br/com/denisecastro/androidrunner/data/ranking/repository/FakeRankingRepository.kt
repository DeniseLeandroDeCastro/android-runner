package br.com.denisecastro.androidrunner.data.ranking.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

class FakeRankingRepository : RankingRepository {

    private val scores = MutableStateFlow<List<Int>>(emptyList())

    override fun observeTopScores(limit: Int): Flow<List<Int>> {
        return scores.map { ranking ->
            ranking.sortedDescending().take(limit)
        }
    }

    override suspend fun saveScore(score: Int) {
        scores.value += score
    }
}