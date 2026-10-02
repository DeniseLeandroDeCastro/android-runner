package br.com.denisecastro.androidrunner.game.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.withFrameNanos
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.denisecastro.androidrunner.game.events.GameUiEvent
import br.com.denisecastro.androidrunner.game.screens.GameScreen
import br.com.denisecastro.androidrunner.game.viewmodel.GameViewModel

@Composable
fun GameRoute(
    onNavigateHome: () -> Unit,
    viewModel: GameViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        var previousFrameTime = 0L

        while (true) {
            withFrameNanos { frameTimeNanos ->

                if (previousFrameTime != 0L) {
                    val deltaTimeSeconds =
                        (frameTimeNanos - previousFrameTime) /
                                1_000_000_000f

                    viewModel.updateGame(
                        deltaTimeSeconds = deltaTimeSeconds
                    )
                }

                previousFrameTime = frameTimeNanos
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