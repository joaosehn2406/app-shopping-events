package com.example.shopping_events_app.ui.addevent

import com.example.shopping_events_app.ui.eventdetails.AddEventDetailsPage

data class AddEventDetails(
    val id: Long = 0,
    val name: String = "",
    val initialBudget: Double = 0.0,
    val totalCost: Double = 0.0,
    val eventDate: String = "",
    val completed: Boolean = false
)

data class AddEventUiState(
    val addEventDetails: AddEventDetails = AddEventDetails(),
    val isEntryValid: Boolean = false
)
