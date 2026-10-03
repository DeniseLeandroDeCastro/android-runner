package br.com.denisecastro.androidrunner.data.ranking.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.core.formatter.ScoreFormatter
import br.com.denisecastro.androidrunner.data.ranking.state.RankingUiState
import br.com.denisecastro.androidrunner.ui.designsystem.components.background.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.components.button.RunnerPrimaryButton
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerGold
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerWhite

@Composable
fun RankingScreen(
    uiState: RankingUiState,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    RunnerBackground(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(
                modifier = Modifier.height(40.dp)
            )

            Text(
                text = "RANKING",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold,
                color = RunnerWhite
            )

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            if (uiState.scores.isEmpty()) {
                Text(
                    text = "Nenhuma partida registrada ainda.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = RunnerWhite,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    itemsIndexed(
                        items = uiState.scores
                    ) { index, score ->

                        RankingItem(
                            position = index + 1,
                            score = score
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            RunnerPrimaryButton(
                onClick = onBackClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "VOLTAR",
                    fontWeight = FontWeight.ExtraBold,
                    color = RunnerBackground
                )
            }
        }
    }
}

@Composable
private fun RankingItem(
    position: Int,
    score: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "${position}º",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = RunnerGold
        )

        Text(
            text = ScoreFormatter.format(score),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = RunnerWhite
        )
    }
}

@Preview(
    name = "Ranking",
    widthDp = 393,
    heightDp = 852
)
@Composable
private fun RankingScreenPreview() {
    AndroidRunnerTheme {
        RankingScreen(
            uiState = RankingUiState(
                scores = listOf(
                    2450,
                    1980,
                    1520,
                    976,
                    720
                )
            ),
            onBackClick = {}
        )
    }
}

@Preview(
    name = "Ranking - Empty",
    widthDp = 393,
    heightDp = 852
)
@Composable
private fun RankingScreenEmptyPreview() {
    AndroidRunnerTheme {
        RankingScreen(
            uiState = RankingUiState(),
            onBackClick = {}
        )
    }
}