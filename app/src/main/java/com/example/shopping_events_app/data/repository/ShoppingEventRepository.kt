package com.example.shopping_events_app.data.repository

import com.example.shopping_events_app.data.dao.ShoppingEventDao
import com.example.shopping_events_app.data.entities.ShoppingEvent
import com.example.shopping_events_app.data.entities.ShoppingItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ShoppingEventRepository {
    suspend fun insert(shoppingEvent: ShoppingEvent)
    suspend fun update(shoppingEvent: ShoppingEvent)
    suspend fun delete(shoppingEvent: ShoppingEvent)
    fun getEvents(): Flow<List<ShoppingEvent>>
    fun getEventWithItemsAndTotalCost(id: Long): Flow<Map<ShoppingEvent, List<ShoppingItem>>>
}

class ShoppingEventRepositoryImpl @Inject constructor(
    private val shoppingEventDao: ShoppingEventDao
) : ShoppingEventRepository {
    override suspend fun insert(shoppingEvent: ShoppingEvent) = shoppingEventDao.insert(shoppingEvent)

    override suspend fun update(shoppingEvent: ShoppingEvent) = shoppingEventDao.update(shoppingEvent)

    override suspend fun delete(shoppingEvent: ShoppingEvent) = shoppingEventDao.delete(shoppingEvent)

    override fun getEvents(): Flow<List<ShoppingEvent>> = shoppingEventDao.getEvents()

    override fun getEventWithItemsAndTotalCost(id: Long): Flow<Map<ShoppingEvent, List<ShoppingItem>>> = shoppingEventDao.getEventWithItemsAndTotalCost(id)

}