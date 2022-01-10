package com.gdsc.expensetracker.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val itemName : String,
    val itemPrice : Int,
    val category: String,
    val dateAndTime : Long
)
