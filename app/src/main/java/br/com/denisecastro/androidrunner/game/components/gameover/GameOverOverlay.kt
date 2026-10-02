package br.com.denisecastro.androidrunner.game.components.gameover

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.core.formatter.ScoreFormatter
import br.com.denisecastro.androidrunner.ui.designsystem.components.background.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.components.button.RunnerPrimaryButton
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerGold
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerSurface
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerWhite
import androidx.compose.foundation.clickable

@Composable
fun GameOverOverlay(
    score: Int,
    highScore: Int,
    onRestartClick: () -> Unit,
    onHomeClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                RunnerBackground.copy(alpha = 0.82f)
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .clip(RoundedCornerShape(28.dp))
                .background(RunnerSurface)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "GAME OVER",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold,
                color = RunnerWhite
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Text(
                text = "Pontuação",
                style = MaterialTheme.typography.bodyMedium,
                color = RunnerWhite
            )

            Text(
                text = ScoreFormatter.format(score),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = RunnerGold
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "Recorde: ${ScoreFormatter.format(highScore)}",
                style = MaterialTheme.typography.bodyLarge,
                color = RunnerWhite
            )

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            RunnerPrimaryButton(
                onClick = onRestartClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "JOGAR NOVAMENTE",
                    fontWeight = FontWeight.ExtraBold,
                    color = RunnerBackground
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "VOLTAR PARA HOME",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = RunnerWhite,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .clickable(onClick = onHomeClick)
                    .padding(12.dp)
            )
        }
    }
}

@Preview(
    name = "Game Over",
    widthDp = 393,
    heightDp = 852
)
@Composable
private fun GameOverOverlayPreview() {
    AndroidRunnerTheme {
        RunnerBackground {
            GameOverOverlay(
                score = 2450,
                highScore = 8750,
                onRestartClick = {},
                onHomeClick = {}
            )
        }
    }
}