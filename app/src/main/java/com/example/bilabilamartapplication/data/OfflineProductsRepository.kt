package com.example.bilabilamartapplication.data

import kotlinx.coroutines.flow.Flow

class OfflineProductsRepository(private val productDao: ProductDao): ProductsRepository {
    override fun getAllItemsStream(): Flow<List<Product>> = productDao.getAllProducts()

    override fun getItemStream(id: Int): Flow<Product?> = productDao.getItem(id)

    override suspend fun insertItem(product: Product) = productDao.insert(product)

    override suspend fun deleteItem(product: Product) = productDao.delete(product)

    override suspend fun updateItem(product: Product) = productDao.update(product)
}