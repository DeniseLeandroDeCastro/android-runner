package br.com.denisecastro.androidrunner.game.components.obstacles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.ui.designsystem.components.background.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerRed

@Composable
fun GameObstacle(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    topStart = 12.dp,
                    topEnd = 12.dp
                )
            )
            .background(RunnerRed)
    )
}

@Preview(
    name = "Game Obstacle",
    widthDp = 160,
    heightDp = 180
)
@Composable
private fun GameObstaclePreview() {
    AndroidRunnerTheme {
        RunnerBackground {
            GameObstacle(
                modifier = Modifier
                    .size(
                        width = 55.dp,
                        height = 70.dp
                    )
                    .align(androidx.compose.ui.Alignment.Center)
            )
        }
    }
}