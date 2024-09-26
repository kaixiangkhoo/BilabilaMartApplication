package com.example.bilabilamartapplication.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: Product)

    @Update
    suspend fun update(product: Product)

    @Delete
    suspend fun delete(product: Product)

    @Query("SELECT * from products WHERE id = :id")
    fun getItem(id: Int): Flow<Product>

    @Query("SELECT * from products ORDER BY prodName ASC")
    fun getAllProducts(): Flow<List<Product>>

}