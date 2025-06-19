package com.example.shopping_events_app.ui.home

import androidx.lifecycle.ViewModel
import com.example.shopping_events_app.data.repository.ShoppingEventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val shoppingEventRepository: ShoppingEventRepository
) : ViewModel(){
    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()

}