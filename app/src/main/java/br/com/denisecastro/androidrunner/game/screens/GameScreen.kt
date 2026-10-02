package br.com.denisecastro.androidrunner.game.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.denisecastro.androidrunner.game.components.GameHud
import br.com.denisecastro.androidrunner.game.events.GameUiEvent
import br.com.denisecastro.androidrunner.game.state.GameUiState
import br.com.denisecastro.androidrunner.ui.designsystem.components.background.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerWhite

@Composable
fun GameScreen(
    uiState: GameUiState,
    onEvent: (GameUiEvent) -> Unit,
    modifier: Modifier = Modifier
){
    RunnerBackground(
        modifier = modifier
    ) {

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            GameHud(
                score = uiState.score,
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