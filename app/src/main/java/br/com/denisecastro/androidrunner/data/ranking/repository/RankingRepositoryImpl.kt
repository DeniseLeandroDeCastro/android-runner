package br.com.denisecastro.androidrunner.data.ranking.repository

import br.com.denisecastro.androidrunner.data.ranking.local.dao.GameScoreDao
import br.com.denisecastro.androidrunner.data.ranking.local.entity.GameScoreEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RankingRepositoryImpl @Inject constructor(
    private val gameScoreDao: GameScoreDao
) : RankingRepository {

    override fun observeTopScores(
        limit: Int
    ): Flow<List<Int>> {
        return gameScoreDao
            .observeTopScores(limit)
            .map { scores ->
                scores.map { gameScore ->
                    gameScore.score
                }
            }
    }

    override suspend fun saveScore(
        score: Int
    ) {
        gameScoreDao.insertScore(
            GameScoreEntity(
                score = score,
                createdAt = System.currentTimeMillis()
            )
        )
    }
}