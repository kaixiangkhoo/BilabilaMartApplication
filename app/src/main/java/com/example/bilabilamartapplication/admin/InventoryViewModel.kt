package com.example.bilabilamartapplication.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bilabilamartapplication.data.Product
import com.example.bilabilamartapplication.data.ProductsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class InventoryViewModel(productsRepository: ProductsRepository) : ViewModel() {

    /**
     * Holds inventory ui state. The list of items are retrieved from [ProductsRepository] and mapped to
     * [InventoryUiState]
     */
    val inventoryUiState: StateFlow<InventoryUiState> =
        productsRepository.getAllItemsStream().map { InventoryUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = InventoryUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * Ui State for InventoryScreen
 */
data class InventoryUiState(val itemList: List<Product> = listOf())