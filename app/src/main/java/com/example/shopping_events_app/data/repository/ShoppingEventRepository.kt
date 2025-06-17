package com.example.shopping_events_app.data.repository

import com.example.shopping_events_app.data.dao.ShoppingEventDao
import com.example.shopping_events_app.data.entities.ShoppingEvent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ShoppingEventRepository {
    suspend fun insert(shoppingEvent: ShoppingEvent)
    suspend fun update(shoppingEvent: ShoppingEvent)
    suspend fun delete(shoppingEvent: ShoppingEvent)
    fun getEvents(): Flow<List<ShoppingEvent>>
}

class ShoppingEventRepositoryImpl @Inject constructor(
    private val shoppingEventDao: ShoppingEventDao
) : ShoppingEventRepository {
    override suspend fun insert(shoppingEvent: ShoppingEvent) {
        TODO("Not yet implemented")
    }

    override suspend fun update(shoppingEvent: ShoppingEvent) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(shoppingEvent: ShoppingEvent) {
        TODO("Not yet implemented")
    }

    override fun getEvents(): Flow<List<ShoppingEvent>> {
        TODO("Not yet implemented")
    }

}