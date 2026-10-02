package br.com.denisecastro.androidrunner.ui.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = RunnerGreen,
    onPrimary = RunnerBackground,
    secondary = RunnerPurple
)

private val RunnerColorScheme = darkColorScheme(
    primary = RunnerGreen,
    onPrimary = RunnerBackground,

    secondary = RunnerPurple,
    onSecondary = RunnerWhite,

    tertiary = RunnerGold,
    onTertiary = RunnerBackground,

    background = RunnerBackground,
    onBackground = RunnerWhite,

    surface = RunnerSurface,
    onSurface = RunnerWhite,

    error = RunnerRed
)

@Composable
fun AndroidRunnerTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = RunnerColorScheme,
        typography = RunnerTypography,
        content = content
    )
}