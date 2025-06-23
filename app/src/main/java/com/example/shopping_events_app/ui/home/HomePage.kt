package com.example.shopping_events_app.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shopping_events_app.customcomp.EmptyListUi
import com.example.shopping_events_app.customcomp.ShoppingAppBar
import com.example.shopping_events_app.data.entities.ShoppingEvent

@Composable
fun HomePage(
    navigateToAddEvent: () -> Unit,
    navigateToEventDetails: (Long, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val uiState by viewModel.homeUiState.collectAsState()
    Scaffold(
        topBar = {
            ShoppingAppBar(
                title = "Shopping Events",
                canNavigateBack = false
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToAddEvent
            ) {
                Icon(Icons.Filled.Add, null)
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        if (uiState.events.isEmpty()) {
            EmptyListUi(
                message = "No events found\nAdd an event to get started",
                modifier = modifier.padding(innerPadding)
            )
            return@Scaffold
        }
        ShoppingList(
            uiState.events,
            navigateToEventDetails = navigateToEventDetails,
            modifier = modifier.padding(innerPadding)
        )
    }
}

@Composable
fun ShoppingList(
    shoppingEvents: List<ShoppingEvent>,
    navigateToEventDetails: (Long, String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(shoppingEvents) { event ->
            ShoppingEventView(
                shoppingEvent = event,
                onTapEvent = navigateToEventDetails
            )
        }
    }
}

@Composable
fun ShoppingEventView(
    shoppingEvent: ShoppingEvent,
    onTapEvent: (Long, String) -> Unit,
    modifier: Modifier = Modifier
) {
    ListItem(
        modifier = modifier
            .padding(8.dp)
            .clickable {
                onTapEvent(shoppingEvent.id, shoppingEvent.name)
            },
        tonalElevation = 3.dp,
        headlineContent = {
            Text(shoppingEvent.name)
        },
        supportingContent = {
            Text(shoppingEvent.eventDate)
        },
        trailingContent = {
            Text("$${shoppingEvent.initialBudget}", style = MaterialTheme.typography.bodyLarge)
        },
        leadingContent = {
            IconButton(
                onClick = {}
            ) {
                Icon(Icons.Filled.Delete, contentDescription = null)
            }
        }
    )
}
