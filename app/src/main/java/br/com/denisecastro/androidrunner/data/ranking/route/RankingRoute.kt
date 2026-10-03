package br.com.denisecastro.androidrunner.data.ranking.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.denisecastro.androidrunner.data.ranking.screens.RankingScreen
import br.com.denisecastro.androidrunner.data.ranking.viewmodel.RankingViewModel

@Composable
fun RankingRoute(
    onNavigateBack: () -> Unit,
    viewModel: RankingViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    RankingScreen(
        uiState = uiState,
        onBackClick = onNavigateBack
    )
}