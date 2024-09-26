package com.example.bilabilamartapplication.admin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bilabilamartapplication.data.ProductsRepository
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

/**
 * ViewModel to retrieve and update an product from the [ProductsRepository]'s data source.
 */
class ProductEditViewModel(
    savedStateHandle: SavedStateHandle,
    private val productsRepository: ProductsRepository
) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var productUiState by mutableStateOf(ProductUiState())
        private set

    private val productId: Int = checkNotNull(savedStateHandle[ProductEditDestination.productIdArg])

    init {
        viewModelScope.launch {
            productUiState = productsRepository.getItemStream(productId)
                .filterNotNull()
                .first()
                .toItemUiState(true)
        }
    }

    /**
     * Update the item in the [ProductsRepository]'s data source
     */
    suspend fun updateProduct() {
        if (validateInput(productUiState.productDetails)) {
            productsRepository.updateItem(productUiState.productDetails.toItem())
        }
    }

    /**
     * Updates the [productUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(productDetails: ProductDetails) {
        productUiState =
            ProductUiState(productDetails = productDetails, isEntryValid = validateInput(productDetails))
    }

    private fun validateInput(uiState: ProductDetails = productUiState.productDetails): Boolean {
        return with(uiState) {
            prodName.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }
}