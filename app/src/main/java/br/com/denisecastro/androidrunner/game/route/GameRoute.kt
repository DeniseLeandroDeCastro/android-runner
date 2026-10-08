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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import br.com.denisecastro.androidrunner.core.audio.GameSoundManager

@Composable
fun GameRoute(
    onNavigateHome: () -> Unit,
    viewModel: GameViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val context = LocalContext.current

    val gameSoundManager = remember {
        GameSoundManager(
            context = context.applicationContext
        )
    }

    DisposableEffect(Unit) {
        onDispose {
            gameSoundManager.release()
        }
    }

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
        onJumpSound = {
            gameSoundManager.playJump()
        },
        onGameOverSound = {
            gameSoundManager.playGameOver()
        },
        onCollectibleSound = {
            gameSoundManager.playCollectible()
        },
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