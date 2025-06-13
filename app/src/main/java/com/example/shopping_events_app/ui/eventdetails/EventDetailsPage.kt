package com.example.shopping_events_app.ui.eventdetails

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shopping_events_app.customcomp.ShoppingAppBar

@Composable
fun AddEventDetailsPage(
    navigateBack: () -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ShoppingAppBar(
                title = "Add Event Details",
                canNavigateBack = true,
                navigateUp = {

                }
            )
        }
    ) {
            innerPadding ->
        Text(
            text = "Add Event Details",
            modifier = modifier.padding(innerPadding)
        )
    }
}