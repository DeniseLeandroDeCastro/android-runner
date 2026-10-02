package br.com.denisecastro.androidrunner.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.denisecastro.androidrunner.home.screens.HomeScreen
import br.com.denisecastro.androidrunner.home.state.HomeUiState

@Composable
fun RunnerNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = RunnerDestination.Home.route,
        modifier = modifier
    ) {

        composable(
            route = RunnerDestination.Home.route
        ) {

            HomeScreen(
                uiState = HomeUiState(
                    highScore = 2450
                ),
                onEvent = { event ->
                    // Trataremos no próximo passo.
                }
            )
        }
    }
}