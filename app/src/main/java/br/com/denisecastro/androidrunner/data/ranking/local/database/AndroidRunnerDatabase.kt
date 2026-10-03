package br.com.denisecastro.androidrunner.data.ranking.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.denisecastro.androidrunner.data.ranking.local.dao.GameScoreDao
import br.com.denisecastro.androidrunner.data.ranking.local.entity.GameScoreEntity

@Database(
    entities = [
        GameScoreEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AndroidRunnerDatabase : RoomDatabase() {

    abstract fun gameScoreDao(): GameScoreDao
}