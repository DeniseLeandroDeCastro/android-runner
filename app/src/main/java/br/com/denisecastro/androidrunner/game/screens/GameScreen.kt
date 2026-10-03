package br.com.denisecastro.androidrunner.game.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.game.components.hud.GameHud
import br.com.denisecastro.androidrunner.game.components.world.GameWorld
import br.com.denisecastro.androidrunner.game.components.character.RunnerCharacter
import br.com.denisecastro.androidrunner.game.events.GameUiEvent
import br.com.denisecastro.androidrunner.game.state.GameUiState
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import androidx.compose.foundation.layout.offset
import br.com.denisecastro.androidrunner.game.components.area.GamePlayArea
import br.com.denisecastro.androidrunner.game.components.obstacles.GameObstacle
import androidx.compose.foundation.layout.fillMaxSize
import br.com.denisecastro.androidrunner.game.components.gameover.GameOverOverlay
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback

@Composable
fun GameScreen(
    uiState: GameUiState,
    onEvent: (GameUiEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val hapticFeedback = LocalHapticFeedback.current

    GameWorld(
        modifier = modifier
    ) {

        GamePlayArea(
            onJump = {
                if (
                    uiState.vibrationEnabled &&
                    !uiState.isJumping &&
                    !uiState.isPaused &&
                    !uiState.isGameOver
                ) {
                    hapticFeedback.performHapticFeedback(
                        HapticFeedbackType.LongPress
                    )
                }

                onEvent(GameUiEvent.JumpClicked)
            }
        ) {
            uiState.obstacles.forEach { obstacle ->
                GameObstacle(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(
                            bottom = 110.dp
                        )
                        .offset(
                            x = obstacle.x.dp
                        )
                        .size(
                            width = obstacle.width.dp,
                            height = obstacle.height.dp
                        )
                )
            }

            RunnerCharacter(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(
                        start = 24.dp,
                        bottom = 82.dp
                    )
                    .offset(
                        y = uiState.playerY.dp
                    )
                    .size(190.dp)
            )
        }

        GameHud(
            score = uiState.score,
            isPaused = uiState.isPaused,
            onPauseClick = {
                onEvent(GameUiEvent.PauseClicked)
            },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(
                    horizontal = 24.dp,
                    vertical = 24.dp
                )
        )
        if (uiState.isGameOver) {
            GameOverOverlay(
                score = uiState.score,
                highScore = uiState.highScore,
                onRestartClick = {
                    onEvent(GameUiEvent.RestartClicked)
                },
                onHomeClick = {
                    onEvent(GameUiEvent.HomeClicked)
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(
    name = "Game Screen",
    widthDp = 393,
    heightDp = 852
)
@Composable
private fun GameScreenPreview() {
    AndroidRunnerTheme {
        GameScreen(
            uiState = GameUiState(
                score = 2450
            ),
            onEvent = {}
        )
    }
}

@Preview(
    name = "Game Screen - Game Over",
    widthDp = 393,
    heightDp = 852
)
@Composable
private fun GameScreenGameOverPreview() {
    AndroidRunnerTheme {
        GameScreen(
            uiState = GameUiState(
                score = 1250,
                highScore = 2450,
                isGameOver = true
            ),
            onEvent = {}
        )
    }
}