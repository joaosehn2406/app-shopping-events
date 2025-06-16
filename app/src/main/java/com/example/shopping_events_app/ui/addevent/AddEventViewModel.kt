package com.example.shopping_events_app.ui.addevent

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class AddEventViewModel : ViewModel() {
    var addEventUiState by mutableStateOf(AddEventUiState())

    fun updateUiState(addEventDetails: AddEventDetails) {
        addEventUiState = AddEventUiState(addEventDetails = addEventDetails, isEntryValid = validateInput(addEventDetails))
    }

    private fun validateInput(eventDetails: AddEventDetails): Boolean {
        return with(eventDetails) {
            name.isNotBlank() && eventDate.isNotBlank()
        }
    }
}