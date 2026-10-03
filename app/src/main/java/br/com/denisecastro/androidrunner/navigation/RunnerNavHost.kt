package br.com.denisecastro.androidrunner.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.denisecastro.androidrunner.data.ranking.route.RankingRoute
import br.com.denisecastro.androidrunner.game.route.GameRoute
import br.com.denisecastro.androidrunner.game.screens.GameScreen
import br.com.denisecastro.androidrunner.game.state.GameUiState
import br.com.denisecastro.androidrunner.home.route.HomeRoute
import br.com.denisecastro.androidrunner.howtoplay.screens.HowToPlayScreen
import br.com.denisecastro.androidrunner.settings.route.SettingsRoute

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

        composable(
            route = RunnerDestination.Game.route
        ) {
            GameRoute(
                onNavigateHome = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = RunnerDestination.HowToPlay.route
        ) {
            HowToPlayScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = RunnerDestination.Ranking.route
        ) {
            RankingRoute(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = RunnerDestination.Settings.route
        ) {
            SettingsRoute(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}