package com.example.bilabilamartapplication.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * from user WHERE userId = :id")
    fun getItem(id: Int): Flow<User>

//    @Query("SELECT * from user ORDER BY  ASC")
//    fun getAllProducts(): Flow<List<User>>
}