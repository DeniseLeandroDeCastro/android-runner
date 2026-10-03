package br.com.denisecastro.androidrunner.data.highscore.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private const val DATA_STORE_NAME = "android_runner_preferences"

private val Context.dataStore by preferencesDataStore(
    name = DATA_STORE_NAME
)

class HighScoreDataStore @Inject constructor(
    @ApplicationContext private val context: Context
) {

    val highScore: Flow<Int> =
        context.dataStore.data.map { preferences ->
            preferences[HIGH_SCORE_KEY] ?: 0
        }

    suspend fun saveHighScore(highScore: Int) {
        context.dataStore.edit { preferences ->
            preferences[HIGH_SCORE_KEY] = highScore
        }
    }

    private companion object {
        val HIGH_SCORE_KEY =
            intPreferencesKey("high_score")
    }
}