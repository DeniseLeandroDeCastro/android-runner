package br.com.denisecastro.androidrunner.howtoplay.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.ui.designsystem.components.background.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.components.button.RunnerPrimaryButton
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerGold
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
                .windowInsetsPadding(WindowInsets.navigationBars)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(
                modifier = Modifier.height(40.dp)
            )

            Text(
                text = "COMO JOGAR",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold,
                color = RunnerWhite
            )

            Spacer(
                modifier = Modifier.height(40.dp)
            )

            HowToPlayItem(
                icon = Icons.Default.TouchApp,
                title = "TOQUE PARA PULAR",
                description =
                    "Toque na tela para fazer o Android saltar."
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            HowToPlayItem(
                icon = Icons.Default.Warning,
                title = "DESVIE DOS OBSTÁCULOS",
                description =
                    "Evite colidir com os obstáculos durante a corrida."
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            HowToPlayItem(
                icon = Icons.Default.EmojiEvents,
                title = "FAÇA MAIS PONTOS",
                description =
                    "Quanto mais tempo você sobreviver, maior será sua pontuação."
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            HowToPlayItem(
                icon = Icons.Default.Pause,
                title = "PAUSE QUANDO PRECISAR",
                description =
                    "Use o botão de pausa durante a partida."
            )

            Spacer(
                modifier = Modifier.weight(1f)
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
private fun HowToPlayItem(
    icon: ImageVector,
    title: String,
    description: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.Top
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = RunnerGold
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold,
                color = RunnerWhite
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = RunnerWhite
            )
        }
    }
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