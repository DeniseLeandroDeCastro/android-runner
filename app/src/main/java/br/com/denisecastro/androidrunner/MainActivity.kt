package br.com.denisecastro.androidrunner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.denisecastro.androidrunner.home.screens.HomeScreen
import br.com.denisecastro.androidrunner.home.state.HomeUiState
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidRunnerTheme {
                HomeScreen(
                    uiState = HomeUiState(
                        highScore = 2450
                    ),
                    onEvent = {}
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    AndroidRunnerTheme {
        HomeScreen(
            onEvent = { },
            uiState = HomeUiState()
        )
    }
}