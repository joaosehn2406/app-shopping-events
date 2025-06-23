package com.example.shopping_events_app.ui.eventdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.shopping_events_app.data.entities.ShoppingItem
import com.example.shopping_events_app.data.repository.ShoppingEventRepository
import com.example.shopping_events_app.data.repository.ShoppingItemRepository
import com.example.shopping_events_app.destinations.EventDetailsRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class EventDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val shoppingEventRepository: ShoppingEventRepository,
    private val itemRepository: ShoppingItemRepository
) : ViewModel() {
    private val detailsRoute: EventDetailsRoute = savedStateHandle.toRoute<EventDetailsRoute>()

    private val _eventDetailsUiState = MutableStateFlow(EventDetailsUiState())
    val eventDetailsUiState = _eventDetailsUiState.asStateFlow()

    suspend fun addItem(){
        val item = ShoppingItem(
            eventId = detailsRoute.eventId,
            itemName = detailsRoute.eventName
        )
        itemRepository.insert(item)
    }

}