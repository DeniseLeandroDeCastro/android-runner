package br.com.denisecastro.androidrunner.di

import android.content.Context
import androidx.room.Room
import br.com.denisecastro.androidrunner.data.ranking.local.dao.GameScoreDao
import br.com.denisecastro.androidrunner.data.ranking.local.database.AndroidRunnerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAndroidRunnerDatabase(
        @ApplicationContext context: Context
    ): AndroidRunnerDatabase {
        return Room.databaseBuilder(
            context,
            AndroidRunnerDatabase::class.java,
            "android_runner.db"
        ).build()
    }

    @Provides
    fun provideGameScoreDao(
        database: AndroidRunnerDatabase
    ): GameScoreDao {
        return database.gameScoreDao()
    }
}