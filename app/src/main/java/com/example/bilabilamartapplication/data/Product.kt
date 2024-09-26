package com.example.bilabilamartapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val prodName: String,
    val price: Double,
    val quantity: Int
)