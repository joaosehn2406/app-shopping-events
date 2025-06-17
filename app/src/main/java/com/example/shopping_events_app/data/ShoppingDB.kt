package com.example.shopping_events_app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shopping_events_app.data.dao.ShoppingEventDao
import com.example.shopping_events_app.data.dao.ShoppingItemDao
import com.example.shopping_events_app.data.entities.ShoppingEvent
import com.example.shopping_events_app.data.entities.ShoppingItem

@Database(entities = [ShoppingEvent::class, ShoppingItem::class], version = 1)
abstract class ShoppingDB : RoomDatabase() {
    abstract fun shoppingEventDao(): ShoppingEventDao
    abstract fun shoppingItemDao(): ShoppingItemDao

    companion object {
        const val DATABASE_NAME = "shopping_database"

        @Volatile
        private var Instance: ShoppingDB? = null


    }
}