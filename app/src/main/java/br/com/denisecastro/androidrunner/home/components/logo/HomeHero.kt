package br.com.denisecastro.androidrunner.home.components.logo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.game.components.character.RunnerCharacter
import br.com.denisecastro.androidrunner.ui.designsystem.components.background.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme

@Composable
fun HomeHero(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        RunnerCharacter(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .sizeIn(maxWidth = 280.dp)
                .aspectRatio(1f)
        )
    }
}

@Preview(
    name = "Home Hero"
)
@Composable
private fun HomeHeroPreview() {
    AndroidRunnerTheme {
        RunnerBackground {
            HomeHero(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}