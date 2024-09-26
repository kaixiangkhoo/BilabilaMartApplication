package com.example.bilabilamartapplication.data

import android.content.Context

interface UserAppContainer {
    val userRepository: UserRepository
}
class UserDataContainer(private val context: Context) : UserAppContainer {
    override val userRepository: UserRepository by lazy {
        OfflineUserRepository(UserProfileDatabase.getDatabase(context).userDao())
    }
}
