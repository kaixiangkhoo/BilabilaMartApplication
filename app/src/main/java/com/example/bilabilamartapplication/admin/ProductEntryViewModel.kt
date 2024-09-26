package com.example.bilabilamartapplication.admin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.bilabilamartapplication.data.Product
import com.example.bilabilamartapplication.data.ProductsRepository
import java.text.NumberFormat

class ProductEntryViewModel(private val productsRepository: ProductsRepository) : ViewModel() {

    //hold current product ui state
    var productUiState by mutableStateOf(ProductUiState())
        private set


    /**
     * Updates the [productUiState] with the value provided in the argument.
     * This method also triggers a validation for input values.
     */
    fun updateUiState(productDetails: ProductDetails) {
        productUiState =
            ProductUiState(productDetails = productDetails, isEntryValid = validateInput(productDetails))
    }

    /**
     * Inserts an [Product] in the Room database
     */
    suspend fun saveProduct() {
        if (validateInput()) {
            productsRepository.insertItem(productUiState.productDetails.toItem())
        }
    }

    private fun validateInput(uiState: ProductDetails = productUiState.productDetails): Boolean {
        return with(uiState) {
            prodName.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }
}


/**
 * Represents Ui State for an Item.
 */
data class ProductUiState(
    val productDetails: ProductDetails = ProductDetails(),
    val isEntryValid: Boolean = false
)

data class ProductDetails(
    val id: Int = 0,
    val prodName: String = "",
    val price: String = "",
    val quantity: String = "",
)

/**
 * Extension function to convert [ProductUiState] to [Product].
 * If the value of [ProductDetails.price] is
 * not a valid [Double], then the price will be set to 0.0. Similarly if the value of
 * [ProductUiState] is not a valid [Int], then the quantity will be set to 0
 */
fun ProductDetails.toItem(): Product = Product(
    id = id,
    prodName = prodName,
    price = price.toDoubleOrNull() ?: 0.0,
    quantity = quantity.toIntOrNull() ?: 0
)

fun Product.formatedPrice(): String {
    return NumberFormat.getCurrencyInstance().format(price)
}

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Product.toItemUiState(isEntryValid: Boolean = false): ProductUiState = ProductUiState(
    productDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Product.toItemDetails(): ProductDetails = ProductDetails(
    id = id,
    prodName = prodName,
    price = price.toString(),
    quantity = quantity.toString()
)