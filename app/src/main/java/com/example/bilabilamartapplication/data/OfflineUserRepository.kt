package com.example.bilabilamartapplication.data

import kotlinx.coroutines.flow.Flow

class OfflineUserRepository(private val userDao: UserDao): UserRepository {
    override fun getItemStream(id: Int): Flow<User?> = userDao.getItem(id)

    override suspend fun insertItem(user: User) = userDao.insert(user)

    override suspend fun deleteItem(user: User) = userDao.delete(user)

    override suspend fun updateItem(user: User) = userDao.update(user)
}

