package br.com.denisecastro.androidrunner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import br.com.denisecastro.androidrunner.home.screens.HomeScreen
import br.com.denisecastro.androidrunner.home.state.HomeUiState
import br.com.denisecastro.androidrunner.navigation.RunnerNavHost
import br.com.denisecastro.androidrunner.ui.designsystem.theme.AndroidRunnerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AndroidRunnerTheme {
                val navController = rememberNavController()
                RunnerNavHost(
                    navController = navController
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