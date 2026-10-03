package br.com.denisecastro.androidrunner.data.settings.repository

import br.com.denisecastro.androidrunner.data.settings.local.SettingsDataStore
import br.com.denisecastro.androidrunner.domain.settings.model.GameSettings
import br.com.denisecastro.androidrunner.domain.settings.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val settingsDataStore: SettingsDataStore
) : SettingsRepository {

    override val settings: Flow<GameSettings>
        get() = settingsDataStore.settings

    override suspend fun setSoundEnabled(
        enabled: Boolean
    ) {
        settingsDataStore.setSoundEnabled(enabled)
    }

    override suspend fun setVibrationEnabled(
        enabled: Boolean
    ) {
        settingsDataStore.setVibrationEnabled(enabled)
    }
}