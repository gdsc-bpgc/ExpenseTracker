package com.gdsc.expensetracker.CategoryList

import android.os.Bundle
import android.util.Log
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
    companion object {
        fun newInstance() = CategoryListFragment()
    }


    private lateinit var viewModel: CategoryListViewModel
    private lateinit var adapter : CategoryListRVAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.category_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

    }
    private fun init(){
        adapter= CategoryListRVAdapter()
        val rv = requireView().findViewById<RecyclerView>(R.id.rv_clf)
        rv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        rv.adapter = adapter
        addData()
        Log.d("CLF","This screen is ok")
    }
    private fun addData(){
        categories = arrayListOf(
            CategoryListRVItem(R.drawable.food_icon, "Food"),
            CategoryListRVItem(R.drawable.laundry_icon, "Laundry"),
            CategoryListRVItem(R.drawable.stationary_icon, "Stationary"),
            CategoryListRVItem(R.drawable.grocery_icon, "Groceries"),
            CategoryListRVItem(R.drawable.clothes_icon, "Clothes"),
            CategoryListRVItem(R.drawable.hygiene_icon, "Hygiene"),
            CategoryListRVItem(R.drawable.electronics_icon, "Electronics"),
            CategoryListRVItem(R.drawable.others_icon, "Others")
        )
        adapter.updateRV(categories)
    }

}