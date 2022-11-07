package com.original.tipsfootball

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.original.tipsfootball.data.TipsRepository
import com.original.tipsfootball.model.TipsEntity
import com.original.tipsfootball.usecase.GetTipsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getTipsRepository: GetTipsUseCase
) : ViewModel() {
    private val _gamesStateFlow = MutableStateFlow(mutableListOf<TipsEntity>())
    val gamesStateFlow = _gamesStateFlow.asStateFlow()

    init {
        doNetworkCall()
    }

    private fun doNetworkCall() {
        viewModelScope.launch {
            _gamesStateFlow.value = getTipsRepository.invoke()
        }
    }
}