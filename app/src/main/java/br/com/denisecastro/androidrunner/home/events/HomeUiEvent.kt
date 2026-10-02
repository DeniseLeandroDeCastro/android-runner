package br.com.denisecastro.androidrunner.home.events

sealed interface HomeUiEvent {
    data object PlayClicked : HomeUiEvent
    data object RankingClicked : HomeUiEvent
    data object HowToPlayClicked : HomeUiEvent
    data object SettingsClicked : HomeUiEvent
}