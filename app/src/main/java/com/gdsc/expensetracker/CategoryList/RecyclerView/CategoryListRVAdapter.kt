package com.gdsc.expensetracker.CategoryList.RecyclerView

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.gdsc.expensetracker.CategoryExpense.CategoryExpenseFragmentDirections
import com.gdsc.expensetracker.CategoryList.CategoryListFragmentDirections
import com.gdsc.expensetracker.R
import java.util.*

class CategoryListRVAdapter() : RecyclerView.Adapter<CategoryViewHolder>() {

    var categories = ArrayList<CategoryListRVItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_rv_item,parent,false)
        Log.d("CLF","RV code is ok")
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        var category = categories[position]
        Log.d("CLF","RV code is ok")
        holder.category_image.setImageResource(category.categoryIconId)
        holder.category_name.text = category.categoryName
        val action = CategoryListFragmentDirections.actionCategoryListFragmentToCategoryExpenseFragment(category.categoryName)
        holder.category_cv.setOnClickListener {
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
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
        Log.d("CLF","getItemCount is ok ${categories.size}")
        return categories.size
    }


    //This function can be used to update data of recycler view after any change in DB
    fun updateRV(categories: ArrayList<CategoryListRVItem>) {
        Log.d("CLF","update is called")
    categories.clear()
    categories.addAll(categories)
    notifyDataSetChanged()
    }

}
class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val category_name = itemView.findViewById<TextView>(R.id.category_name_tv_clrvi)
    val category_image = itemView.findViewById<ImageView>(R.id.category_image_rv_item)
    val category_cv = itemView.findViewById<CardView>(R.id.category_cv_item)
}
