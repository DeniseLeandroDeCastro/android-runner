package br.com.denisecastro.androidrunner.game.components.character

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.R
import br.com.denisecastro.androidrunner.ui.designsystem.components.background.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme

@Composable
fun RunnerCharacter(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(
            id = R.drawable.runner_character
        ),
        contentDescription = "Android Runner character",
        modifier = modifier,
        contentScale = ContentScale.Fit
    )
}

@Preview(
    name = "Runner Character",
    showBackground = true,
    widthDp = 393,
    heightDp = 400
)
@Composable
private fun RunnerCharacterPreview() {
    AndroidRunnerTheme {
        RunnerBackground {
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(24.dp)
            ) {
                RunnerCharacter(
                    modifier = Modifier.size(280.dp)
                )
            }
        }
    }
}