package com.example.shopping_events_app.ui.eventdetails

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shopping_events_app.customcomp.ShoppingAppBar
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun AddEventDetailsPage(
    navigateBack: () -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EventDetailsViewModel = hiltViewModel()
) {
    val uiState by viewModel.eventDetailsUiState.collectAsState()
    val corouineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            ShoppingAppBar(
                title = "Weekly Grocery Shopping",
                modifier = modifier,
                canNavigateBack = true,
                navigateUp = navigateUp,
                navigateBack = navigateUp
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    corouineScope.launch {
                        viewModel.addItem()
                    }
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
                Text(text = "Add Item")
            }
        }
    ) { innerPadding ->
        Text(
            text = "Add Event Details",
            modifier = modifier.padding(innerPadding)
        )
    }
}