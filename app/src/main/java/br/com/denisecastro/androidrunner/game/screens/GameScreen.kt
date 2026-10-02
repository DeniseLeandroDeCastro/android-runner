package br.com.denisecastro.androidrunner.game.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.game.components.GameHud
import br.com.denisecastro.androidrunner.game.components.GameWorld
import br.com.denisecastro.androidrunner.game.components.character.RunnerCharacter
import br.com.denisecastro.androidrunner.game.events.GameUiEvent
import br.com.denisecastro.androidrunner.game.state.GameUiState
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.offset

@Composable
fun GameScreen(
    uiState: GameUiState,
    onEvent: (GameUiEvent) -> Unit,
    modifier: Modifier = Modifier
){
    GameWorld(
        modifier = modifier
            .clickable {
                onEvent(GameUiEvent.JumpClicked)
            }
    ) {
        RunnerCharacter(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(
                    start = 24.dp,
                    bottom = 82.dp
                )
                .offset(y = uiState.playerY.dp)
                .size(190.dp)
        )
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