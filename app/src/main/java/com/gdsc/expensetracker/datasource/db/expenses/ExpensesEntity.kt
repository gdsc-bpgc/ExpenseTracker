package com.gdsc.expensetracker.datasource.db.expenses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class ExpensesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "expense_id")
    val expenseId: Int,
    @ColumnInfo(name = "expense_amount")
    val expenseAmount : Double,
    @ColumnInfo(name = "expense_details")
    val expenseDetails : String

)