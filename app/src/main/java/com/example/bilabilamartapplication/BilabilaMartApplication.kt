package com.example.bilabilamartapplication

import android.app.Application
import com.example.bilabilamartapplication.data.AppContainer
import com.example.bilabilamartapplication.data.AppDataContainer
import com.example.bilabilamartapplication.data.UserAppContainer
import com.example.bilabilamartapplication.data.UserDataContainer

class BilabilaMartApplication: Application(){
    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer
    lateinit var userContainer: UserAppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
        userContainer = UserDataContainer(this)
    }
}