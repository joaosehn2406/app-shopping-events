package com.example.shopping_events_app.ui.addevent

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.shopping_events_app.data.repository.ShoppingEventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEventViewModel @Inject constructor(
    private val shoppingEventRepository: ShoppingEventRepository
) : ViewModel() {
    var addEventUiState by mutableStateOf(AddEventUiState())

    fun updateUiState(addEventDetails: AddEventDetails) {
        addEventUiState = AddEventUiState(addEventDetails = addEventDetails, isEntryValid = validateInput(addEventDetails))
    }

    private fun validateInput(eventDetails: AddEventDetails = addEventUiState.addEventDetails): Boolean {
        return with(eventDetails) {
            name.isNotBlank() && eventDate.isNotBlank()
        }
    }

    suspend fun saveEvent() {
        if (validateInput()) {
            shoppingEventRepository.insert(addEventUiState.addEventDetails.toShoppingEvent())
        }
    }
}