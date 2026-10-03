package br.com.denisecastro.androidrunner.data.highscore.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import br.com.denisecastro.androidrunner.data.local.datastore.androidRunnerDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HighScoreDataStore @Inject constructor(
    @ApplicationContext private val context: Context
) {

    val highScore: Flow<Int> =
        context.androidRunnerDataStore.data.map { preferences ->
            preferences[HIGH_SCORE_KEY] ?: 0
        }

    suspend fun saveHighScore(highScore: Int) {
        context.androidRunnerDataStore.edit { preferences ->
            preferences[HIGH_SCORE_KEY] = highScore
        }
    }

    private companion object {
        val HIGH_SCORE_KEY =
            intPreferencesKey("high_score")
    }
}