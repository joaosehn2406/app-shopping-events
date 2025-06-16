package com.example.shopping_events_app.ui.addevent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopping_events_app.customcomp.ShoppingAppBar

@Composable
fun AddEventPage(
    navigateBack: () -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AddEventViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            ShoppingAppBar(
                title = "Add Event",
                modifier = modifier
                    .size(16.dp),
                canNavigateBack = true,
                navigateUp = navigateUp,
                navigateBack = navigateBack
            )
        }
    ) {  innerPadding ->
        EventForm(
            uiState = viewModel.addEventUiState,
            onEventValueChange = viewModel::updateUiState,
            onSaveClick = {},
            modifier = modifier.padding(innerPadding)
        )
    }
}


@Composable
fun EventForm(
    uiState: AddEventUiState,
    onEventValueChange: (AddEventDetails) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextInputField(
            addEventDetails = uiState.addEventDetails,
            onEventValueChange = onEventValueChange
        )
    }
}

@Composable
fun TextInputField(
    addEventDetails: AddEventDetails,
    onEventValueChange: (AddEventDetails) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = addEventDetails.name,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            onValueChange = {
                onEventValueChange(addEventDetails.copy(name = it))
            },
            label = {
                Text(text = "Event name")
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = addEventDetails.initialBudget,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            onValueChange = {
                onEventValueChange(addEventDetails.copy(name = it))
            },
            label = {
                Text(text = "Initial Budget (Optional)")
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EventFormPreview() {
    AddEventPage(
        navigateBack = TODO(),
        navigateUp = TODO(),
        modifier = TODO(),
        viewModel = viewModel()
    )
}