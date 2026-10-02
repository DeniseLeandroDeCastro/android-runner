package br.com.denisecastro.androidrunner.home.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.denisecastro.androidrunner.home.events.HomeUiEvent
import br.com.denisecastro.androidrunner.home.state.HomeUiState
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onEvent: (HomeUiEvent) -> Unit
) {
    // organização da tela
}

@Preview(
    name = "Home Screen",
    showSystemUi = true,
    widthDp = 393,
    heightDp = 852
)
@Composable
private fun HomeScreenPreview() {
    AndroidRunnerTheme {
        HomeScreen(
            uiState = HomeUiState(),
            onEvent = { }
        )
    }
}