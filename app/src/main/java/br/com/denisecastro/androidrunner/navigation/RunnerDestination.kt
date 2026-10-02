package br.com.denisecastro.androidrunner.navigation

import kotlinx.serialization.Serializable

sealed class RunnerDestination(
    val route: String
) {

    data object Home : RunnerDestination(
        route = "home"
    )

    data object Game : RunnerDestination(
        route = "game"
    )

    data object Ranking : RunnerDestination(
        route = "ranking"
    )

    data object HowToPlay : RunnerDestination(
        route = "how_to_play"
    )

    data object Settings : RunnerDestination(
        route = "settings"
    )
}