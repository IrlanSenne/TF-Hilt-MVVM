package com.senne.footballltips.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.senne.footballltips.model.PredictionsEntity
import com.senne.footballltips.model.TipsEntity
import com.senne.footballltips.usecase.GetGamesListUseCase
import com.senne.footballltips.usecase.GetTipUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGamesListUseCase: GetGamesListUseCase,
    private val getTipUseCase: GetTipUseCase
) : ViewModel() {
    private val _gamesStateFlow = MutableStateFlow(mutableListOf<TipsEntity>())
    val gamesStateFlow = _gamesStateFlow.asStateFlow()

    private val _tipStateFlow = MutableStateFlow<PredictionsEntity?>(null)
    val tipStateFlow = _tipStateFlow.asStateFlow()

    init {
        getGamesList()
    }

    private fun getGamesList() {
        viewModelScope.launch {
            getGamesListUseCase.invoke().onEach { result ->
                _gamesStateFlow.value = result
            }.launchIn(viewModelScope)
        }
    }

    private fun getTip(fixture: String) {
        viewModelScope.launch {
            getTipUseCase.invoke(fixture).onEach { predictions ->
                _tipStateFlow.value = predictions
            }.launchIn(viewModelScope)
        }
    }
}