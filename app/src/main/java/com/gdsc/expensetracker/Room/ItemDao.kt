package com.gdsc.expensetracker.Room

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import androidx.lifecycle.LiveData
import androidx.room.*
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit
import java.util.*

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(item : Item)

    @Query("SELECT * FROM item_table ORDER BY dateAndTime ASC")
    fun readAllData() : LiveData<List<Item>>

    // TODO temporary change this
    @RequiresApi(Build.VERSION_CODES.O)
    @Query("SELECT SUM(itemPrice) FROM item_table WHERE dateAndTime > :dayStart")
    fun readForDay(dayStart : Long = Calendar.getInstance().toInstant().truncatedTo(ChronoUnit.DAYS).toEpochMilli()) : LiveData<Int>
    // TODO temporary change this
    @RequiresApi(Build.VERSION_CODES.O)
    @Query("SELECT SUM(itemPrice) FROM item_table WHERE dateAndTime > :monthStart")
    fun readForMoth(monthStart : Long = Calendar.getInstance().toInstant().truncatedTo(ChronoUnit.MONTHS).toEpochMilli()) : LiveData<Int>
    @Delete
    suspend fun deleteItem(item : Item)
}