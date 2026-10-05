package br.com.denisecastro.androidrunner.settings.screens

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.denisecastro.androidrunner.settings.state.SettingsUiState
import br.com.denisecastro.androidrunner.ui.designsystem.components.background.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.components.button.RunnerPrimaryButton
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerBackground
import br.com.denisecastro.androidrunner.ui.designsystem.theme.RunnerWhite

@Composable
fun SettingsScreen(
    uiState: SettingsUiState,
    onSoundEnabledChange: (Boolean) -> Unit,
    onVibrationEnabledChange: (Boolean) -> Unit,
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
                text = "OPÇÕES",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold,
                color = RunnerWhite
            )

            Spacer(
                modifier = Modifier.height(48.dp)
            )

            SettingItem(
                title = "Som",
                checked = uiState.soundEnabled,
                onCheckedChange = onSoundEnabledChange
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            SettingItem(
                title = "Vibração",
                checked = uiState.vibrationEnabled,
                onCheckedChange = onVibrationEnabledChange
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
private fun SettingItem(
    title: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = RunnerWhite
        )

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Preview(
    name = "Settings",
    widthDp = 393,
    heightDp = 852
)
@Composable
private fun SettingsScreenPreview() {
    AndroidRunnerTheme {
        SettingsScreen(
            uiState = SettingsUiState(
                soundEnabled = true,
                vibrationEnabled = true
            ),
            onSoundEnabledChange = {},
            onVibrationEnabledChange = {},
            onBackClick = {}
        )
    }
}