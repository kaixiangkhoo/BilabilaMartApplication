package com.example.bilabilamartapplication.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Product] from a given data source.
 */
interface ProductsRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllItemsStream(): Flow<List<Product>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getItemStream(id: Int): Flow<Product?>

    /**
     * Insert item in the data source
     */
    suspend fun insertItem(product: Product)

    /**
     * Delete item from the data source
     */
    suspend fun deleteItem(product: Product)

    /**
     * Update item in the data source
     */
    suspend fun updateItem(product: Product)
}