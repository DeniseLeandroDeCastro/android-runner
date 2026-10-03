package br.com.denisecastro.androidrunner.data.settings.local

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import br.com.denisecastro.androidrunner.data.local.datastore.androidRunnerDataStore
import br.com.denisecastro.androidrunner.domain.settings.model.GameSettings
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsDataStore @Inject constructor(
    @ApplicationContext private val context: Context
) {

    val settings: Flow<GameSettings> =
        context.androidRunnerDataStore.data.map { preferences ->
            GameSettings(
                soundEnabled =
                    preferences[SOUND_ENABLED_KEY] ?: true,
                vibrationEnabled =
                    preferences[VIBRATION_ENABLED_KEY] ?: true
            )
        }

    suspend fun setSoundEnabled(
        enabled: Boolean
    ) {
        context.androidRunnerDataStore.edit { preferences ->
            preferences[SOUND_ENABLED_KEY] = enabled
        }
    }

    suspend fun setVibrationEnabled(
        enabled: Boolean
    ) {
        context.androidRunnerDataStore.edit { preferences ->
            preferences[VIBRATION_ENABLED_KEY] = enabled
        }
    }

    private companion object {

        val SOUND_ENABLED_KEY =
            booleanPreferencesKey("sound_enabled")

        val VIBRATION_ENABLED_KEY =
            booleanPreferencesKey("vibration_enabled")
    }
}