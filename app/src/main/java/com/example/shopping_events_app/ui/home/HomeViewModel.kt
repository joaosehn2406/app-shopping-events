package com.example.shopping_events_app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopping_events_app.data.repository.ShoppingEventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val shoppingEventRepository: ShoppingEventRepository
) : ViewModel() {
    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState

    init {
        viewModelScope.launch {
            shoppingEventRepository.getEvents()
                .collect { events ->
                    _homeUiState.update {
                        it.copy(events = events)
                    }
                }
        }
    }
}

