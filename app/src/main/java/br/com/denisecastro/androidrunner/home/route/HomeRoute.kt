package br.com.denisecastro.androidrunner.home.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.denisecastro.androidrunner.home.events.HomeUiEvent
import br.com.denisecastro.androidrunner.home.screens.HomeScreen
import br.com.denisecastro.androidrunner.home.viewmodel.HomeViewModel

@Composable
fun HomeRoute(
    onNavigateToGame: () -> Unit,
    onNavigateToRanking: () -> Unit,
    onNavigateToHowToPlay: () -> Unit,
    onNavigateToSettings: () -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    HomeScreen(
        uiState = uiState,
        onEvent = { event ->
            when (event) {
                HomeUiEvent.PlayClicked -> onNavigateToGame()
                HomeUiEvent.RankingClicked -> onNavigateToRanking()
                HomeUiEvent.HowToPlayClicked -> onNavigateToHowToPlay()
                HomeUiEvent.SettingsClicked -> onNavigateToSettings()
            }
        }
    )
}