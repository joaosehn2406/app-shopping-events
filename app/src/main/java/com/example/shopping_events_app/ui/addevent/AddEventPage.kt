package com.example.shopping_events_app.ui.addevent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopping_events_app.customcomp.ShoppingAppBar
import com.example.shopping_events_app.utils.formatDate
import kotlinx.coroutines.launch

@Composable
fun AddEventPage(
    navigateBack: () -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AddEventViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            ShoppingAppBar(
                title = "Add Event",
                modifier = modifier,
                canNavigateBack = true,
                navigateUp = navigateUp,
                navigateBack = navigateBack
            )
        }
    ) { innerPadding ->
        EventForm(
            uiState = viewModel.addEventUiState,
            onEventValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.saveEvent()
                    navigateBack()
                }
            },
            modifier = modifier.padding(innerPadding)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventForm(
    uiState: AddEventUiState,
    onEventValueChange: (AddEventDetails) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var openDataPickerDialog by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
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

        DatePickerUi(
            shouldOpenDialog = openDataPickerDialog,
            state = datePickerState,
            onDismissRequest = {
                openDataPickerDialog = false
            },
            onClickConfirmButton = {
                datePickerState.selectedDateMillis?.let {
                    onEventValueChange(uiState.addEventDetails.copy(
                        eventDate = formatDate(it)!!
                    ))
                }
                openDataPickerDialog = false
            },
            onClickCancelButton = {
                openDataPickerDialog = false
            }
        )

        DatePickerButtonUi(
            state = datePickerState,
            onSelectDateButtonClick = {
                openDataPickerDialog = true
            }
        )

        Button(
            onClick = onSaveClick,
            enabled = uiState.isEntryValid,
            modifier = Modifier.fillMaxWidth().padding(20.dp)
        ) {
            Text(text = "Save")
        }
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
                onEventValueChange(addEventDetails.copy(initialBudget = it))
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerButtonUi(
    state: DatePickerState,
    onSelectDateButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        ElevatedButton(
            onClick = onSelectDateButtonClick
        ) {
            Text("Select Date")
        }

        Text(text = formatDate(state.selectedDateMillis) ?: "Nothing selected")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerUi(
    shouldOpenDialog: Boolean,
    state: DatePickerState,
    onDismissRequest: () -> Unit,
    onClickConfirmButton: () -> Unit,
    onClickCancelButton: () -> Unit,
    modifier: Modifier = Modifier
) {

    if (shouldOpenDialog) {
        val confirmEnabled by remember {
            derivedStateOf { state.selectedDateMillis != null }
        }

        DatePickerDialog(
            modifier = modifier,
            onDismissRequest = onDismissRequest,
            confirmButton = {
                TextButton(
                    enabled = confirmEnabled,
                    onClick = onClickConfirmButton
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onClickCancelButton
                ) {
                    Text("CANCEL")
                }
            }
        ) {
            DatePicker(
                state = state
            )
        }
    }
}

