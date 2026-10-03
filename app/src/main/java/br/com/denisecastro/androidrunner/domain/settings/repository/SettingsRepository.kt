package br.com.denisecastro.androidrunner.domain.settings.repository

import br.com.denisecastro.androidrunner.domain.settings.model.GameSettings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    val settings: Flow<GameSettings>

    suspend fun setSoundEnabled(
        enabled: Boolean
    )

    suspend fun setVibrationEnabled(
        enabled: Boolean
    )
}