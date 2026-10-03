package br.com.denisecastro.androidrunner.settings.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.denisecastro.androidrunner.settings.screens.SettingsScreen
import br.com.denisecastro.androidrunner.settings.viewmodel.SettingsViewModel

@Composable
fun SettingsRoute(
    onNavigateBack: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    SettingsScreen(
        uiState = uiState,
        onSoundEnabledChange = viewModel::onSoundEnabledChange,
        onVibrationEnabledChange = viewModel::onVibrationEnabledChange,
        onBackClick = onNavigateBack
    )
}