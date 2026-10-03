package br.com.denisecastro.androidrunner.di

import br.com.denisecastro.androidrunner.data.highscore.repository.HighScoreRepositoryImpl
import br.com.denisecastro.androidrunner.data.ranking.repository.RankingRepository
import br.com.denisecastro.androidrunner.domain.highscore.repository.HighScoreRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import br.com.denisecastro.androidrunner.data.ranking.repository.RankingRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHighScoreRepository(
        implementation: HighScoreRepositoryImpl
    ): HighScoreRepository

    @Binds
    @Singleton
    abstract fun bindRankingRepository(
        implementation: RankingRepositoryImpl
    ): RankingRepository
}