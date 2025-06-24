package com.example.shopping_events_app.customcomp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DismissibleItem(
    onDelete: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    var dismissItem by remember { mutableStateOf(false) }
    val dismissState = rememberSwipeToDismissBoxState(
        confirmValueChange = {
            when(it) {
                SwipeToDismissBoxValue.StartToEnd -> {}
                SwipeToDismissBoxValue.EndToStart -> {
                    showDialog = true
                    return@rememberSwipeToDismissBoxState false
                }
                SwipeToDismissBoxValue.Settled -> {
                    return@rememberSwipeToDismissBoxState false
                }
            }
            return@rememberSwipeToDismissBoxState false
        },
        positionalThreshold = {
            it * 0.75f
        }
    )

    if (showDialog) {
        AlertDialog(
            title = { Text("Are you sure you want to delete this item?") },
            onDismissRequest = {
                showDialog = false
            },
            confirmButton = {
                IconButton(
                    onClick = {
                        showDialog = false
                        dismissItem = true
                        onDelete()
                    }
                ) {
                    Icon(Icons.Default.Done, contentDescription = null)
                }
            },
            dismissButton = {
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(Icons.Default.Close, contentDescription = null)
                }
            }

        )
    }
}