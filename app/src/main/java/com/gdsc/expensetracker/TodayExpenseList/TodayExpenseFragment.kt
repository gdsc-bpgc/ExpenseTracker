package com.gdsc.expensetracker.TodayExpenseList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gdsc.expensetracker.CategoryList.RecyclerView.CategoryListRVAdapter
import com.gdsc.expensetracker.CategoryList.RecyclerView.CategoryListRVItem
import com.gdsc.expensetracker.R
import com.gdsc.expensetracker.TodayExpenseList.RecyclerView.TodayExpenseRVAdapter

class TodayExpenseFragment : Fragment() {

    companion object {
        fun newInstance() = TodayExpenseFragment()
    }
    var expenses = ArrayList<CategoryListRVItem>()
    lateinit var adapter : TodayExpenseRVAdapter

    private lateinit var viewModel: TodayExpenseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.today_expense_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val rv = requireView().findViewById<RecyclerView>(R.id.todays_expense_rv_tef)
//        rv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
//        rv.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TodayExpenseViewModel::class.java)
        // TODO: Use the ViewModel
    }


}