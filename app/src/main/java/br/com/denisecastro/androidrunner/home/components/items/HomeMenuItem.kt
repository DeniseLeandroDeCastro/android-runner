package br.com.denisecastro.androidrunner.home.components.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.ui.designsystem.components.background.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerSurface
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerWhite

@Composable
fun HomeMenuItem(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(18.dp))
            .background(RunnerSurface)
            .clickable(onClick = onClick)
            .padding(
                horizontal = 8.dp,
                vertical = 14.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = RunnerWhite,
            modifier = Modifier.size(28.dp)
        )

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = RunnerWhite,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 6.dp)
        )
    }
}

@Preview(
    name = "Home Menu Item",
    showBackground = true
)
@Composable
private fun HomeMenuItemPreview() {
    AndroidRunnerTheme {
        RunnerBackground {
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(24.dp)
            ) {
                HomeMenuItem(
                    title = "Ranking",
                    icon = Icons.Default.EmojiEvents,
                    onClick = {},
                    modifier = Modifier.size(
                        width = 105.dp,
                        height = 90.dp
                    )
                )
            }
        }
    }
}