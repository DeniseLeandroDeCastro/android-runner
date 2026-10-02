package br.com.denisecastro.androidrunner.home.components.button

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.ui.designsystem.components.button.RunnerPrimaryButton
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerBackground

@Composable
fun PlayButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    RunnerPrimaryButton(
        onClick = onClick,
        modifier = modifier
    ) {

        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = null,
            tint = RunnerBackground,
            modifier = Modifier.size(34.dp)
        )

        Spacer(
            modifier = Modifier.width(10.dp)
        )

        Text(
            text = "JOGAR",
            color = RunnerBackground,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Preview(
    name = "Play Button",
    showBackground = true,
    backgroundColor = 0xFF071A3D,
    widthDp = 393
)
@Composable
private fun PlayButtonPreview() {
    AndroidRunnerTheme {
        PlayButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )
    }
}