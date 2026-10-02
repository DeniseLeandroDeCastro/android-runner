package br.com.denisecastro.androidrunner.home.components.menus

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Gamepad
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.denisecastro.androidrunner.home.components.items.HomeMenuItem
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import androidx.compose.ui.unit.dp

@Composable
fun HomeMenu(
    onRankingClick: () -> Unit,
    onHowToPlayClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        HomeMenuItem(
            title = "Ranking",
            icon = Icons.Default.EmojiEvents,
            onClick = onRankingClick,
            modifier = Modifier.weight(1f)
        )

        HomeMenuItem(
            title = "Como jogar",
            icon = Icons.Default.Gamepad,
            onClick = onHowToPlayClick,
            modifier = Modifier.weight(1f)
        )

        HomeMenuItem(
            title = "Opções",
            icon = Icons.Default.Settings,
            onClick = onSettingsClick,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(
    name = "Home Menu",
    showBackground = true,
    backgroundColor = 0xFF071A3D,
    widthDp = 393
)
@Composable
private fun HomeMenuPreview() {
    AndroidRunnerTheme {
        HomeMenu(
            onRankingClick = {},
            onHowToPlayClick = {},
            onSettingsClick = {}
        )
    }
}