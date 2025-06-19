package com.example.shopping_events_app.ui.eventdetails

import com.example.shopping_events_app.ui.addevent.AddEventDetails

data class ItemDetails(
    val itemId: Long = 0,
    val eventId: Long = 0,
    val name: String = "",
    val price: String = "",
    val quantity: String = ""
)

data class ItemUiState(
    val isEditable: Boolean = false,
    val itemDetails: ItemDetails = ItemDetails()
)

data class EventDetailsUiState(
    val eventDetails: AddEventDetails = AddEventDetails(),
    val itemList: List<ItemUiState> = emptyList()
)