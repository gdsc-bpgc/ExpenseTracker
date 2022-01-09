package com.gdsc.expensetracker.CategoryList.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.gdsc.expensetracker.R

class CategoryListRVAdapter : RecyclerView.Adapter<CategoryViewHolder>() {
    var categories = ArrayList<CategoryListRVItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_rv_item,parent,false)
            return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        var category = categories[position]
        holder.category_image.setImageResource(category.categoryIconId)
        holder.category_name.text = category.categoryName
        holder.category_cv.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }


    //This function can be used to update data of recycler view after any change in DB
    fun updateRV(categories: ArrayList<CategoryListRVItem>) {
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
