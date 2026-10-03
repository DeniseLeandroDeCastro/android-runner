package br.com.denisecastro.androidrunner.game.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.withFrameNanos
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.denisecastro.androidrunner.game.events.GameUiEvent
import br.com.denisecastro.androidrunner.game.screens.GameScreen
import br.com.denisecastro.androidrunner.game.viewmodel.GameViewModel

@Composable
fun GameRoute(
    onNavigateHome: () -> Unit,
    viewModel: GameViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        var lastFrameTimeNanos = 0L
        while (true) {
            withFrameNanos { frameTimeNanos ->
                if (lastFrameTimeNanos != 0L) {
                    val deltaTimeSeconds =
                        (frameTimeNanos - lastFrameTimeNanos) / 1_000_000_000f
                    viewModel.updateGame(deltaTimeSeconds)
                }
                lastFrameTimeNanos = frameTimeNanos
            }
        }
    }

    GameScreen(
        uiState = uiState,
        onEvent = { event ->
            when (event) {
                GameUiEvent.HomeClicked -> {
                    onNavigateHome()
                }
                else -> {
                    viewModel.onEvent(event)
                }
            }
        }
    )
}