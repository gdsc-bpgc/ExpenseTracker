package com.gdsc.expensetracker.TodayExpenseList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gdsc.expensetracker.R

class TodayExpenseFragment : Fragment() {

    companion object {
        fun newInstance() = TodayExpenseFragment()
    }

    private lateinit var viewModel: TodayExpenseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.today_expense_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TodayExpenseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}