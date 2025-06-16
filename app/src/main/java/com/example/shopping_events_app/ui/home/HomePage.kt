package com.example.shopping_events_app.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shopping_events_app.customcomp.ShoppingAppBar

@Composable
fun HomePage(
    navigateToAddEvent: () -> Unit,
    modifier: Modifier = Modifier
) {
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
        }
    ) {
        innerPadding ->
        Text(
            text = "Home Page",
            modifier = modifier.padding(innerPadding)
        )
    }
}