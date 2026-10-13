package br.com.denisecastro.androidrunner.domain.settings.repository

import br.com.denisecastro.androidrunner.domain.settings.model.GameSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeSettingsRepository : SettingsRepository {

    private val _settings = MutableStateFlow(
        GameSettings(
            soundEnabled = true,
            vibrationEnabled = true
        )
    )

    override val settings: Flow<GameSettings> = _settings

    override suspend fun setSoundEnabled(enabled: Boolean) {
        _settings.value = _settings.value.copy(
            soundEnabled = enabled
        )
    }

    override suspend fun setVibrationEnabled(enabled: Boolean) {
        _settings.value = _settings.value.copy(
            vibrationEnabled = enabled
        )
    }
}
