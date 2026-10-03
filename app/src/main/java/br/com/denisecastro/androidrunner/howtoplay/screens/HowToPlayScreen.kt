package br.com.denisecastro.androidrunner.howtoplay.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.ui.designsystem.components.background.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.components.button.RunnerPrimaryButton
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerWhite

@Composable
fun HowToPlayScreen(
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "COMO JOGAR",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold,
                color = RunnerWhite
            )

            Spacer(
                modifier = Modifier.height(40.dp)
            )

            InstructionText(
                text = "Toque na tela para fazer o Android pular."
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            InstructionText(
                text = "Desvie dos obstáculos durante a corrida."
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            InstructionText(
                text = "Quanto mais tempo você permanecer no jogo, maior será sua pontuação."
            )

            Spacer(
                modifier = Modifier.height(40.dp)
            )

            RunnerPrimaryButton(
                onClick = onBackClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "ENTENDI",
                    fontWeight = FontWeight.ExtraBold,
                    color = RunnerBackground
                )
            }
        }
    }
}

@Composable
private fun InstructionText(
    text: String
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        color = RunnerWhite,
        textAlign = TextAlign.Center
    )
}

@Preview(
    name = "How To Play",
    widthDp = 393,
    heightDp = 852
)
@Composable
private fun HowToPlayScreenPreview() {
    AndroidRunnerTheme {
        HowToPlayScreen(
            onBackClick = {}
        )
    }
}