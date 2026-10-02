package br.com.denisecastro.androidrunner.home.components.logo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerGold
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerGreen
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerWhite

@Composable
fun GameLogo(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "ANDROID",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 3.sp
            ),
            color = RunnerWhite,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(2.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "RUN",
                style = MaterialTheme.typography.displayLarge.copy(
                    fontWeight = FontWeight.Black,
                    letterSpacing = 1.sp
                ),
                color = RunnerGreen
            )

            Text(
                text = "NER",
                style = MaterialTheme.typography.displayLarge.copy(
                    fontWeight = FontWeight.Black,
                    letterSpacing = 1.sp
                ),
                color = RunnerGold
            )
        }
    }
}

@Preview(
    name = "Game Logo",
    showBackground = true,
    backgroundColor = 0xFF071A3D
)
@Composable
private fun GameLogoPreview() {
    AndroidRunnerTheme {
        GameLogo()
    }
}