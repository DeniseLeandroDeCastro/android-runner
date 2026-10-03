package br.com.denisecastro.androidrunner.data.ranking.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.denisecastro.androidrunner.data.ranking.local.entity.GameScoreEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameScoreDao {

    @Insert
    suspend fun insertScore(
        gameScore: GameScoreEntity
    )

    @Query(
        """
        SELECT * FROM game_scores
        ORDER BY score DESC, createdAt ASC
        LIMIT :limit
        """
    )
    fun observeTopScores(
        limit: Int
    ): Flow<List<GameScoreEntity>>
}