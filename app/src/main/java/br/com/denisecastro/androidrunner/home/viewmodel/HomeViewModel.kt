package br.com.denisecastro.androidrunner.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.denisecastro.androidrunner.domain.highscore.repository.HighScoreRepository
import br.com.denisecastro.androidrunner.home.events.HomeUiEvent
import br.com.denisecastro.androidrunner.home.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val highScoreRepository: HighScoreRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        HomeUiState()
    )

    val uiState: StateFlow<HomeUiState> =
        _uiState.asStateFlow()

    init {
        observeHighScore()
    }

    private fun observeHighScore() {
        viewModelScope.launch {
            highScoreRepository.highScore.collect { highScore ->
                _uiState.update { state ->
                    state.copy(
                        highScore = highScore
                    )
                }
            }
        }
    }

    fun onEvent(event: HomeUiEvent) {
        when (event) {
            HomeUiEvent.PlayClicked -> Unit
            HomeUiEvent.RankingClicked -> Unit
            HomeUiEvent.HowToPlayClicked -> Unit
            HomeUiEvent.SettingsClicked -> Unit
        }
    }
}