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
import androidx.compose.runtime.LaunchedEffect
import br.com.denisecastro.androidrunner.game.components.collectibles.GameCollectible
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.alpha
import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.Color

@Composable
fun GameScreen(
    uiState: GameUiState,
    onEvent: (GameUiEvent) -> Unit,
    onJumpSound: () -> Unit,
    onGameOverSound: () -> Unit,
    onCollectibleSound: () -> Unit,
    modifier: Modifier = Modifier
) {
    val hapticFeedback = LocalHapticFeedback.current

    LaunchedEffect(uiState.collectedPointsFeedback) {
        if (
            uiState.collectedPointsFeedback != null &&
            uiState.soundEnabled
        ) {
            onCollectibleSound()
        }
    }

    LaunchedEffect(uiState.isGameOver) {
        if (uiState.isGameOver) {

            if (uiState.vibrationEnabled) {
                hapticFeedback.performHapticFeedback(
                    HapticFeedbackType.LongPress
                )
            }

            if (uiState.soundEnabled) {
                onGameOverSound()
            }
        }
    }

    GameWorld(
        modifier = modifier
    ) {

        GamePlayArea(
            onJump = {
                val canJump = !uiState.isJumping &&
                            !uiState.isPaused &&
                            !uiState.isGameOver

                if (canJump) {

                    if (uiState.vibrationEnabled) {
                        hapticFeedback.performHapticFeedback(
                            HapticFeedbackType.LongPress
                        )
                    }

                    if (uiState.soundEnabled) {
                        onJumpSound()
                    }
                }

                onEvent(GameUiEvent.JumpClicked)
            }
        ) {
            uiState.obstacles.forEach { obstacle ->
                GameObstacle(
                    type = obstacle.type,
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

            uiState.collectibles.forEach { collectible ->
                GameCollectible(
                    type = collectible.type,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(
                            bottom = 110.dp
                        )
                        .offset(
                            x = collectible.x.dp,
                            y = (-collectible.y).dp
                        )
                        .size(collectible.size.dp)
                )
            }

            // Feedback dos pontos ganhos ao coletar um item
            uiState.collectedPointsFeedback?.let { points ->

                val offsetY = remember(points) {
                    Animatable(0f)
                }

                val alpha = remember(points) {
                    Animatable(1f)
                }

                LaunchedEffect(points) {
                    offsetY.snapTo(0f)
                    alpha.snapTo(1f)

                    launch {
                        offsetY.animateTo(
                            targetValue = -60f,
                            animationSpec = tween(durationMillis = 800)
                        )
                    }

                    launch {
                        alpha.animateTo(
                            targetValue = 0f,
                            animationSpec = tween(durationMillis = 800)
                        )
                    }
                }

                Text(
                    text = "+$points",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(
                            start = 90.dp,
                            bottom = 210.dp
                        )
                        .offset(
                            y = offsetY.value.dp
                        )
                        .alpha(alpha.value)
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
            onEvent = {},
            onJumpSound = {},
            onGameOverSound = {},
            onCollectibleSound = {},
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
            onEvent = {},
            onJumpSound = {},
            onGameOverSound = {},
            onCollectibleSound = {},
        )
    }
}