package com.original.tipsfootball

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.original.tipsfootball.data.FireBaseRepository
import com.original.tipsfootball.model.TipsEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fireBaseRepository: FireBaseRepository
) : ViewModel() {
    private val _gamesStateFlow = MutableStateFlow(mutableListOf<TipsEntity>())
    val gamesStateFlow = _gamesStateFlow.asStateFlow()

    init {
        doNetworkCall()
    }

    private fun doNetworkCall() {
        viewModelScope.launch {
            _gamesStateFlow.emit(fireBaseRepository.doNetworkCall())
        }
    }
}