package com.example.bilabilamartapplication.data

import android.content.Context

interface AppContainer {
    val productsRepository: ProductsRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineProductsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [productsRepository]
     */
    override val productsRepository: ProductsRepository by lazy {
        OfflineProductsRepository(InventoryDatabase.getDatabase(context).productDao())
    }
}