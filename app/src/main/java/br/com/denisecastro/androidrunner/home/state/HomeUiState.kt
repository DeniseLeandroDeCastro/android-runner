package br.com.denisecastro.androidrunner.home.state

data class HomeUiState(
    val highScore: Int = 0,
    val isLoading: Boolean = false
)