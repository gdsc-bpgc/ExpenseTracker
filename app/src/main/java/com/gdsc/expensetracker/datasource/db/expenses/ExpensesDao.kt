package com.gdsc.expensetracker.datasource.db.expenses

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface ExpensesDao {

    @Query("SELECT * FROM expenses WHERE expense_id = :expenseID")
    suspend fun searchByID(expenseID: Int): Flow<ExpensesEntity>

    // TODO replace is probably not the best way to go about this.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expense : ExpensesEntity)

    @Query("SELECT* FROM expenses")
    suspend fun getAllExpenses(): Flow<List<ExpensesEntity>>
}