package br.com.denisecastro.androidrunner.game.components.area

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.denisecastro.androidrunner.ui.designsystem.components.background.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme

@Composable
fun GamePlayArea(
    onJump: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable(onClick = onJump),
        content = content
    )
}

@Preview(
    name = "Game Play Area",
    widthDp = 393,
    heightDp = 852
)
@Composable
private fun GamePlayAreaPreview() {
    AndroidRunnerTheme {
        RunnerBackground {
            GamePlayArea(
                onJump = {}
            )
        }
    }
}