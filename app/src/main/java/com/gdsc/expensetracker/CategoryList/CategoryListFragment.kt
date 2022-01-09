package com.gdsc.expensetracker.CategoryList

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

class CategoryListFragment : Fragment() {
    var categories = ArrayList<CategoryListRVItem>()
    lateinit var adapter : CategoryListRVAdapter
    companion object {
        fun newInstance() = CategoryListFragment()
    }

    private lateinit var viewModel: CategoryListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.category_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CategoryListViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val rv = requireView().findViewById<RecyclerView>(R.id.ca)
//        rv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
//        rv.adapter = adapter
    }

}