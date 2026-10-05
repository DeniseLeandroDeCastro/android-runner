package br.com.denisecastro.androidrunner.home.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.home.components.logo.HomeHero
import br.com.denisecastro.androidrunner.home.components.button.PlayButton
import br.com.denisecastro.androidrunner.home.components.cards.HighScoreCard
import br.com.denisecastro.androidrunner.home.components.component.logo.GameLogo
import br.com.denisecastro.androidrunner.home.components.menus.HomeMenu
import br.com.denisecastro.androidrunner.home.events.HomeUiEvent
import br.com.denisecastro.androidrunner.home.state.HomeUiState
import br.com.denisecastro.androidrunner.ui.designsystem.components.background.RunnerBackground
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
                .windowInsetsPadding(WindowInsets.navigationBars)
                .padding(
                    horizontal = 24.dp,
                    vertical = 32.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(
                modifier = Modifier.weight(0.5f)
            )

            GameLogo()

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            HomeHero()

            PlayButton(
                onClick = {
                    onEvent(HomeUiEvent.PlayClicked)
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            HighScoreCard(
                highScore = uiState.highScore,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.weight(1f)
            )

            HomeMenu(
                onRankingClick = {
                    onEvent(HomeUiEvent.RankingClicked)
                },
                onHowToPlayClick = {
                    onEvent(HomeUiEvent.HowToPlayClicked)
                },
                onSettingsClick = {
                    onEvent(HomeUiEvent.SettingsClicked)
                }
            )
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

@Preview(
    name = "Home - Small Screen",
    showBackground = true,
    widthDp = 360,
    heightDp = 740
)
@Composable
private fun HomeScreenSmallPreview() {
    AndroidRunnerTheme {
        HomeScreen(
            uiState = HomeUiState(
                highScore = 2450
            ),
            onEvent = {}
        )
    }
}