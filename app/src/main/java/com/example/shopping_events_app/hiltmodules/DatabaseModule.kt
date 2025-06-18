package com.example.shopping_events_app.hiltmodules

import android.content.Context
import com.example.shopping_events_app.data.ShoppingDB
import com.example.shopping_events_app.data.dao.ShoppingEventDao
import com.example.shopping_events_app.data.dao.ShoppingItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideShoppingEventDao(@ApplicationContext context: Context): ShoppingEventDao {
        return ShoppingDB.getDatabase(context).shoppingEventDao()
    }

    @Provides
    fun provideShoppingItemDao(@ApplicationContext context: Context): ShoppingItemDao {
        return ShoppingDB.getDatabase(context).shoppingItemDao()
    }
}