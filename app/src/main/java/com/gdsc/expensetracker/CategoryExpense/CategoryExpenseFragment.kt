package com.gdsc.expensetracker.CategoryExpense

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gdsc.expensetracker.R

class CategoryExpenseFragment : Fragment() {

    companion object {
        fun newInstance() = CategoryExpenseFragment()
    }

    private lateinit var viewModel: CategoryExpenseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.category_expense_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CategoryExpenseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}