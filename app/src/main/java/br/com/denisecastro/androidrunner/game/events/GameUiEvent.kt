package br.com.denisecastro.androidrunner.game.events

sealed interface GameUiEvent {
    data object PauseClicked : GameUiEvent
    data object JumpClicked : GameUiEvent
}