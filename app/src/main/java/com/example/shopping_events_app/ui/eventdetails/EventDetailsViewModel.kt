package com.example.shopping_events_app.ui.eventdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.shopping_events_app.data.entities.ShoppingItem
import com.example.shopping_events_app.data.repository.ShoppingEventRepository
import com.example.shopping_events_app.data.repository.ShoppingItemRepository
import com.example.shopping_events_app.destinations.EventDetailsRoute
import com.example.shopping_events_app.ui.addevent.AddEventDetails
import com.example.shopping_events_app.ui.addevent.toAddEventDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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

    init {
        viewModelScope.launch {
            shoppingEventRepository.getEventWithItemsAndTotalCost(detailsRoute.eventId)
                .collect { map ->
                    val entry = map.entries.firstOrNull()
                    _eventDetailsUiState.update {
                        it.copy(
                            eventDetails = entry?.key?.toAddEventDetails() ?: AddEventDetails(
                                name = detailsRoute.eventName
                            ),
                            itemList = entry?.value?.map { item ->
                                ItemUiState(itemDetails = item.toItemDetails())
                            } ?: emptyList())
                    }
                }
        }
    }

    fun enableEditMode(itemDetails: ItemDetails) {
        _eventDetailsUiState.update { state ->
            state.copy(
                itemList = state.itemList.map {
                    if (it.itemDetails.itemId == itemDetails.itemId) {
                        it.copy(isEditable = true)
                    } else {
                        it
                    }
                })
        }
    }

    fun updateUiState(itemDetails: ItemDetails) {
        _eventDetailsUiState.update { state ->
            state.copy(itemList = state.itemList.map {
                if (it.itemDetails.itemId == itemDetails.itemId) {
                    it.copy(itemDetails = itemDetails)
                } else {
                    it
                }
            }

            )
        }
    }

    suspend fun addItem() {
        val item = ShoppingItem(
            eventId = detailsRoute.eventId, itemName = detailsRoute.eventName
        )
        itemRepository.insert(item)
    }

    suspend fun updateItem(itemDetails: ItemDetails){
        itemRepository.update(itemDetails.toShoppingItem())
    }

}