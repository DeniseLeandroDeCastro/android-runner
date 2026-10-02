package br.com.denisecastro.androidrunner.home.viewmodel

import androidx.lifecycle.ViewModel
import br.com.denisecastro.androidrunner.home.events.HomeUiEvent
import br.com.denisecastro.androidrunner.home.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        HomeUiState(
            highScore = 2450
        )
    )

    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onEvent(event: HomeUiEvent) {
        when (event) {
            HomeUiEvent.PlayClicked -> Unit
            HomeUiEvent.RankingClicked -> Unit
            HomeUiEvent.HowToPlayClicked -> Unit
            HomeUiEvent.SettingsClicked -> Unit
        }
    }
}