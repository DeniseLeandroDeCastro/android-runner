package br.com.denisecastro.androidrunner.data.ranking.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.denisecastro.androidrunner.data.ranking.repository.RankingRepository
import br.com.denisecastro.androidrunner.data.ranking.state.RankingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val rankingRepository: RankingRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(RankingUiState())

    val uiState: StateFlow<RankingUiState> =
        _uiState.asStateFlow()

    init {
        observeRanking()
    }

    private fun observeRanking() {
        viewModelScope.launch {
            rankingRepository
                .observeTopScores(TOP_SCORES_LIMIT)
                .collect { scores ->
                    _uiState.update { state ->
                        state.copy(
                            scores = scores
                        )
                    }
                }
        }
    }

    private companion object {
        const val TOP_SCORES_LIMIT = 10
    }
}