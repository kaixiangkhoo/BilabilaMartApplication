package com.example.bilabilamartapplication.data

import kotlinx.coroutines.flow.Flow

interface UserRepository {
//    fun getAllItemsStream(): Flow<List<User>>
    fun getItemStream(id: Int): Flow<User?>
    suspend fun insertItem(user: User)
    suspend fun deleteItem(user: User)
    suspend fun updateItem(user: User)
}