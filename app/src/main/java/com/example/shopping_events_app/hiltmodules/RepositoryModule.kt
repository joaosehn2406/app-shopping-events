package com.example.shopping_events_app.hiltmodules

import com.example.shopping_events_app.data.repository.ShoppingEventRepository
import com.example.shopping_events_app.data.repository.ShoppingEventRepositoryImpl
import com.example.shopping_events_app.data.repository.ShoppingItemRepository
import com.example.shopping_events_app.data.repository.ShoppingItemRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindShoppingEventRepository(impl: ShoppingEventRepositoryImpl): ShoppingEventRepository

    @Binds
    abstract fun bindShoppingItemRepository(impl: ShoppingItemRepositoryImpl): ShoppingItemRepository
}