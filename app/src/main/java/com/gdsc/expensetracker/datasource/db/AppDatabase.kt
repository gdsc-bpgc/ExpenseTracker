package com.gdsc.expensetracker.datasource.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gdsc.expensetracker.datasource.db.expenses.ExpensesDao
import com.gdsc.expensetracker.datasource.db.expenses.ExpensesEntity

@Database(entities = [ExpensesEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun expensesDao() : ExpensesDao

}