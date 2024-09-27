package com.example.bilabilamartapplication

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bilabilamartapplication.admin.InventoryViewModel
import com.example.bilabilamartapplication.admin.ProductDetailsViewModel
import com.example.bilabilamartapplication.admin.ProductEditViewModel
import com.example.bilabilamartapplication.admin.ProductEntryViewModel
import com.example.bilabilamartapplication.user.SignUpViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire bilabila mart app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ProductEditViewModel
        initializer {
            ProductEditViewModel(
                this.createSavedStateHandle(),
                bilabilaMartApplication().container.productsRepository
            )
        }
        // Initializer for ProductEntryViewModel
        initializer {
            ProductEntryViewModel(bilabilaMartApplication().container.productsRepository)
        }

        // Initializer for ProductDetailsViewModel
        initializer {
            ProductDetailsViewModel(
                this.createSavedStateHandle(),
                bilabilaMartApplication().container.productsRepository
            )
        }

        // Initializer for InventoryViewModel
        initializer {
            InventoryViewModel(bilabilaMartApplication().container.productsRepository)
        }

        //User Part
        initializer {
            SignUpViewModel(bilabilaMartApplication().userContainer.userRepository)
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [BilabilaMartApplication].
 */
fun CreationExtras.bilabilaMartApplication(): BilabilaMartApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as BilabilaMartApplication)