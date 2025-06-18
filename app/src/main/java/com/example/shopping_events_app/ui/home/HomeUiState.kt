package com.example.shopping_events_app.ui.home

import com.example.shopping_events_app.data.entities.ShoppingEvent

data class HomeUiState(
    val events: List<ShoppingEvent> = emptyList<ShoppingEvent>()
)