package br.com.denisecastro.androidrunner.home.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.home.events.HomeUiEvent
import br.com.denisecastro.androidrunner.home.state.HomeUiState
import br.com.denisecastro.androidrunner.ui.designsystem.component.background.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onEvent: (HomeUiEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    RunnerBackground(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 24.dp,
                    vertical = 32.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Logo
            // Personagem
            // Botão Jogar
            // Recorde
            // Menu inferior

        }
    }
}

@Preview(
    name = "Home Screen",
    showBackground = true,
    widthDp = 393,
    heightDp = 852
)
@Composable
private fun HomeScreenPreview() {
    AndroidRunnerTheme {
        HomeScreen(
            uiState = HomeUiState(
                highScore = 2450
            ),
            onEvent = {}
        )
    }
}