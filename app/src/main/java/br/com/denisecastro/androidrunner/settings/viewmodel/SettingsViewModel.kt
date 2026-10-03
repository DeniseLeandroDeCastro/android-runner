package br.com.denisecastro.androidrunner.settings.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.denisecastro.androidrunner.domain.settings.repository.SettingsRepository
import br.com.denisecastro.androidrunner.settings.state.SettingsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(SettingsUiState())

    val uiState: StateFlow<SettingsUiState> =
        _uiState.asStateFlow()

    init {
        observeSettings()
    }

    private fun observeSettings() {
        viewModelScope.launch {
            settingsRepository.settings.collect { settings ->
                _uiState.update { state ->
                    state.copy(
                        soundEnabled = settings.soundEnabled,
                        vibrationEnabled = settings.vibrationEnabled
                    )
                }
            }
        }
    }

    fun onSoundEnabledChange(
        enabled: Boolean
    ) {
        viewModelScope.launch {
            settingsRepository.setSoundEnabled(enabled)
        }
    }

    fun onVibrationEnabledChange(
        enabled: Boolean
    ) {
        viewModelScope.launch {
            settingsRepository.setVibrationEnabled(enabled)
        }
    }
}