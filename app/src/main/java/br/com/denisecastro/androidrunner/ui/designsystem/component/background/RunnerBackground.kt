package br.com.denisecastro.androidrunner.ui.designsystem.component.background

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerBackgroundLight

@Composable
fun RunnerBackground(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit = {}
) {
    val backgroundBrush = Brush.verticalGradient(
        colors = listOf(
            RunnerBackgroundLight,
            RunnerBackground
        )
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundBrush),
        content = content
    )
}

@Preview(
    name = "Runner Background",
    showBackground = true,
    widthDp = 393,
    heightDp = 852
)
@Composable
private fun RunnerBackgroundPreview() {
    AndroidRunnerTheme {
        RunnerBackground()
    }
}

