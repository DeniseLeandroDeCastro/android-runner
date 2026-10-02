package br.com.denisecastro.androidrunner.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.denisecastro.androidrunner.home.route.HomeRoute

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
            HomeRoute(
                onNavigateToGame = {
                    navController.navigate(
                        RunnerDestination.Game.route
                    )
                },
                onNavigateToRanking = {
                    navController.navigate(
                        RunnerDestination.Ranking.route
                    )
                },
                onNavigateToHowToPlay = {
                    navController.navigate(
                        RunnerDestination.HowToPlay.route
                    )
                },
                onNavigateToSettings = {
                    navController.navigate(
                        RunnerDestination.Settings.route
                    )
                }
            )
        }
    }
}