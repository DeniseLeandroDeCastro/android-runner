package br.com.denisecastro.androidrunner.game.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerBackgroundLight
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerGround
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerGroundTop
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerSkyBottom
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerSkyTop

@Composable
fun GameWorld(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        RunnerSkyTop,
                        RunnerSkyBottom
                    )
                )
            )
    ) {

        GameGround(
            modifier = Modifier.align(Alignment.BottomCenter)
        )

        content()
    }
}

@Composable
private fun GameGround(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp)
            .background(RunnerGround)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(RunnerGroundTop)
        )
    }
}

@Preview(
    name = "Game World",
    widthDp = 393,
    heightDp = 852
)
@Composable
private fun GameWorldPreview() {
    AndroidRunnerTheme {
        GameWorld()
    }
}