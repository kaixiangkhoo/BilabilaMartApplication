package com.example.bilabilamartapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Int = 0,
    val title: String = "",
    val name: String = "",
    val lastName: String = "",
    val race: String = "",
    val dob: String = "",
    val phone: String = "",
    val email: String = "",
    val unit: String = "",
    val road: String = "",
    val state: String = "",
    val city: String = "",
    val postalCode: String = ""
)
