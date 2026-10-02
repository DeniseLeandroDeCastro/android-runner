package br.com.denisecastro.androidrunner.home.components.logo

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.ui.designsystem.components.background.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.components.character.RunnerCharacter
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme

@Composable
fun HomeHero(
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        val characterSize = if (maxHeight < 800.dp) {
            280.dp
        } else {
            320.dp
        }

        RunnerCharacter(
            modifier = Modifier.size(characterSize)
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