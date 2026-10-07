package br.com.denisecastro.androidrunner.game.components.obstacles

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.R
import br.com.denisecastro.androidrunner.ui.designsystem.components.background.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme

@Composable
fun GameObstacle(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(
            id = R.drawable.obstacle_bug
        ),
        contentDescription = "Obstacle",
        modifier = modifier,
        contentScale = ContentScale.Fit
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