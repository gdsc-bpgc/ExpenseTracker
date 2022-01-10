package com.gdsc.expensetracker.CategoryExpense

import android.app.Application
import androidx.lifecycle.*


class CategoryExpenseViewModel(application: Application) : AndroidViewModel(application) {





}








// Aditya kurkure's code ----------------------------
//    private val database = DatabaseProvider(application)
//    val allExpenseLiveData : LiveData<List<CategoryExpenseRVItem>>  = liveData {
//            database.expensesDao().getAllExpenses().collectLatest { flow ->
//                emit(flow.map { it.toRVItem() })
//            }
//    }
//
//    fun insertExpense(rvItem : CategoryExpenseRVItem) {
//        viewModelScope.launch {  database.expensesDao().insert(rvItem.toEntity())
//    }
//    }
// ------------------------------------------------------------