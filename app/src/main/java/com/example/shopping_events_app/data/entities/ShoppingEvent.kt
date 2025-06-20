package com.example.shopping_events_app.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
// classe que vai ao DB
@Entity(tableName = "shopping_events")
data class ShoppingEvent(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String = "",
    @ColumnInfo(name = "initial_budget") val initialBudget: Double = 0.0,
    @ColumnInfo(name = "total_cost")val totalCost: Double = 0.0,
    @ColumnInfo(name = "event_date")val eventDate: String = "",
    val completed: Boolean = false
)

