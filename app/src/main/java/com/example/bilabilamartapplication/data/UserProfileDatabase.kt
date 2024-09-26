package com.example.bilabilamartapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserProfileDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var instance: UserProfileDatabase? = null

        fun getDatabase(context: Context): UserProfileDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(context, UserProfileDatabase::class.java, "user_profile_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { instance = it }
            }
        }
    }
}
