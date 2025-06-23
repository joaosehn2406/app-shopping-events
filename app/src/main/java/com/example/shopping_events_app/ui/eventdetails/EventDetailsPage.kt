package com.example.shopping_events_app.ui.eventdetails

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shopping_events_app.customcomp.EmptyListUi
import com.example.shopping_events_app.customcomp.ShoppingAppBar
import com.example.shopping_events_app.ui.addevent.AddEventDetails
import kotlinx.coroutines.launch

@Composable
fun AddEventDetailsPage(
    navigateBack: () -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EventDetailsViewModel = hiltViewModel()
) {
    val uiState by viewModel.eventDetailsUiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()

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
                    coroutineScope.launch { viewModel.addItem() }
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
                Text(text = "Add Item")
            }
        }
    ) { innerPadding ->
        if (uiState.itemList.isEmpty()) {
            EmptyListUi(
                message = "No items found.\nAdd an item to get started.",
                modifier = modifier.padding(innerPadding)
            )
            return@Scaffold
        }

        ShoppingItemList(
            eventDetails = uiState.eventDetails,
            itemList = uiState.itemList,
            modifier = modifier.padding(innerPadding)
        )
    }
}

@Composable
fun ShoppingItemList(
    eventDetails: AddEventDetails,
    itemList: List<ItemUiState>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        item {
            ListItem(
                colors = ListItemDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                headlineContent = {
                    Text(
                        "Budget: $${eventDetails.initialBudget}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                trailingContent = {
                    Text(
                        "$${eventDetails.totalCost}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            )
        }
        items(
            items = itemList,
            key = { it.itemDetails.itemId }
        ) { itemUiState ->
            ListItem(
                headlineContent = { Text(itemUiState.itemDetails.name) },
                supportingContent = { Text("Quantity: ${itemUiState.itemDetails.quantity}")},
                trailingContent = { Text("$${itemUiState.itemDetails.price}", style = MaterialTheme.typography.bodyLarge)}
            )
        }
    }
}
