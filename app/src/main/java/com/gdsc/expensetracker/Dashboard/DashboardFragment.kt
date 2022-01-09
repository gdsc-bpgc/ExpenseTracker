package com.gdsc.expensetracker.Dashboard

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import com.gdsc.expensetracker.R

class DashboardFragment : Fragment() {

    companion object {
        fun newInstance() = DashboardFragment()
    }

    private lateinit var viewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.dashboard_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val todayListBtn = view.findViewById<CardView>(R.id.today_exp_cv_df)
        val newExpBtn = view.findViewById<CardView>(R.id.add_exp_cv_df)

        todayListBtn.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_todayExpenseFragment)
        }
        newExpBtn.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_categoryListFragment)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        // TODO: Use the ViewModel
    }

}