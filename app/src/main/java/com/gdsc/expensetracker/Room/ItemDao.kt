package com.gdsc.expensetracker.Room

import androidx.annotation.RequiresPermission
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(item : Item)

    @Query("SELECT * FROM item_table ORDER BY id ASC")
    fun readAllData() : LiveData<List<Item>>

    @Delete
    suspend fun deleteItem(item : Item)
}