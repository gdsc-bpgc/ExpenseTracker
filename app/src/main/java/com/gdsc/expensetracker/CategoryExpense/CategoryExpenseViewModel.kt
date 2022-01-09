package com.gdsc.expensetracker.CategoryExpense

import android.app.Application
import androidx.lifecycle.*
import com.gdsc.expensetracker.CategoryExpense.RecyclerView.CategoryExpenseRVItem
import com.gdsc.expensetracker.CategoryList.RecyclerView.CategoryListRVItem
import com.gdsc.expensetracker.datasource.db.DatabaseProvider
import com.gdsc.expensetracker.datasource.db.expenses.toEntity
import com.gdsc.expensetracker.datasource.db.expenses.toRVItem
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CategoryExpenseViewModel(application: Application) : AndroidViewModel(application) {
    private val database = DatabaseProvider(application)
    val allExpenseLiveData : LiveData<List<CategoryExpenseRVItem>>  = liveData {
            database.expensesDao().getAllExpenses().collectLatest { flow ->
                emit(flow.map { it.toRVItem() })
            }
    }

    fun insertExpense(rvItem : CategoryExpenseRVItem) {
        viewModelScope.launch {  database.expensesDao().insert(rvItem.toEntity())
    }
    }

}