package br.com.denisecastro.androidrunner.home.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.core.formatter.ScoreFormatter
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerGold
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerSurface
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerTextSecondary
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerWhite

@Composable
fun HighScoreCard(
    highScore: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(RunnerSurface)
            .padding(
                horizontal = 20.dp,
                vertical = 14.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Icon(
            imageVector = Icons.Default.EmojiEvents,
            contentDescription = null,
            tint = RunnerGold,
            modifier = Modifier.size(40.dp)
        )

        Column {

            Text(
                text = "Seu recorde",
                style = MaterialTheme.typography.bodyMedium,
                color = RunnerTextSecondary
            )

            Text(
                text = ScoreFormatter.format(highScore),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.ExtraBold,
                color = RunnerGold
            )
        }
    }
}

@Preview(
    name = "High Score Card",
    showBackground = true,
    backgroundColor = 0xFF071A3D,
    widthDp = 393
)
@Composable
private fun HighScoreCardPreview() {
    AndroidRunnerTheme {
        HighScoreCard(
            highScore = 2450,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )
    }
}