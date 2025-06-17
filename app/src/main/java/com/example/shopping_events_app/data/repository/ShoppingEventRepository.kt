package com.example.shopping_events_app.data.repository

import com.example.shopping_events_app.data.entities.ShoppingEvent
import kotlinx.coroutines.flow.Flow

interface ShoppingEventRepository {
    suspend fun insert(shoppingEvent: ShoppingEvent)
    suspend fun update(shoppingEvent: ShoppingEvent)
    suspend fun delete(shoppingEvent: ShoppingEvent)
    fun getEvents(): Flow<List<ShoppingEvent>>
}
