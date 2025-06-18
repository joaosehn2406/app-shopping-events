package com.example.shopping_events_app.data.repository

import com.example.shopping_events_app.data.dao.ShoppingItemDao
import com.example.shopping_events_app.data.entities.ShoppingItem
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

interface ShoppingItemRepository {
    suspend fun insert(shoppingItem: ShoppingItem)
    suspend fun update(shoppingItem: ShoppingItem)
    suspend fun delete(shoppingItem: ShoppingItem)
    fun getEvents(): Flow<List<ShoppingItem>>
}

class ShoppingItemRepositoryImpl @Inject constructor(
    private val shoppingItemDao: ShoppingItemDao
) : ShoppingItemRepository {
    override suspend fun insert(shoppingItem: ShoppingItem) = shoppingItemDao.insert(shoppingItem)

    override suspend fun update(shoppingItem: ShoppingItem) = shoppingItemDao.update(shoppingItem)

    override suspend fun delete(shoppingItem: ShoppingItem) = shoppingItemDao.delete(shoppingItem)

    override fun getEvents(): Flow<List<ShoppingItem>> = shoppingItemDao.getItems()

}