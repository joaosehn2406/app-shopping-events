package com.example.shopping_events_app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.shopping_events_app.data.entities.ShoppingEvent
import com.example.shopping_events_app.data.entities.ShoppingItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingEventDao {
    @Insert
    suspend fun insert(shoppingEvent: ShoppingEvent)

    @Update
    suspend fun update(shoppingEvent: ShoppingEvent)

    @Delete
    suspend fun delete(shoppingEvent: ShoppingEvent)

    @Query("SELECT * FROM shopping_events")
    fun getEvents(): Flow<List<ShoppingEvent>>

    @Query("""
    SELECT 
        se.id, 
        se.name, 
        se.initial_budget, 
        se.event_date, 
        se.completed,
        (SELECT SUM(i2.price * i2.quantity) FROM shopping_items i2 WHERE i2.event_id = se.id) AS total_cost,
        i.itemId, 
        i.event_id, 
        i.item_name, 
        i.price, 
        i.quantity
    FROM shopping_events se
    LEFT JOIN shopping_items i ON se.id = i.event_id
    WHERE se.id = :id
""")
    fun getEventWithItemsAndTotalCost(id: Long): Flow<Map<ShoppingEvent, List<ShoppingItem>>>


}