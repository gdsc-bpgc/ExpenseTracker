package com.gdsc.expensetracker.datasource.db.expenses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gdsc.expensetracker.CategoryExpense.RecyclerView.CategoryExpenseRVItem

@Entity(tableName = "expenses")
data class ExpensesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "expense_id")
    val expenseId: Int,
    @ColumnInfo(name = "expense_amount")
    val expenseAmount : Double,
    @ColumnInfo(name = "expense_details")
    val expenseDetails : String,
    @ColumnInfo(name=  "expense_date")
    val expenseDate : Long
)

fun ExpensesEntity.toRVItem() : CategoryExpenseRVItem{
    return CategoryExpenseRVItem(this.expenseDetails,this.expenseAmount)
}

fun CategoryExpenseRVItem.toEntity(): ExpensesEntity {
    return ExpensesEntity(0,this.amount,this.name,123)
}