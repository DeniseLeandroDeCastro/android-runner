package br.com.denisecastro.androidrunner.ui.designsystem.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerGreen
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerLightGreen
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerBackground

@Composable
fun RunnerPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    val shape = RoundedCornerShape(24.dp)

    Row(
        modifier = modifier
            .height(72.dp)
            .clip(shape)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        RunnerLightGreen,
                        RunnerGreen
                    )
                )
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        content = content
    )
}

@Preview(
    name = "Runner Primary Button",
    showBackground = true,
    backgroundColor = 0xFF071A3D,
    widthDp = 393
)
@Composable
private fun RunnerPrimaryButtonPreview() {
    AndroidRunnerTheme {
        RunnerPrimaryButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(
                text = "JOGAR",
                color = RunnerBackground,
                fontWeight = FontWeight.Bold
            )
        }
    }
}