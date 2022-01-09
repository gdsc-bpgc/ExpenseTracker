package com.gdsc.expensetracker.CategoryExpense.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gdsc.expensetracker.CategoryList.RecyclerView.CategoryViewHolder
import com.gdsc.expensetracker.R

class CategoryExpenseRVAdapter: RecyclerView.Adapter<CategoryExpViewHolder>() {
    var expenditures = ArrayList<CategoryExpenseRVItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryExpViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.today_exp_rv_item,parent,false)
        return CategoryExpViewHolder(view)
    }


    override fun getItemCount(): Int {
        return expenditures.size
    }

    override fun onBindViewHolder(holder: CategoryExpViewHolder, position: Int) {
        var expenditure = expenditures[position]
        holder.exp_name.text = expenditure.name
        holder.exp_amount.text = expenditure.amount.toString()
    }
}

class CategoryExpViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val new_exp_name = itemView.findViewById<EditText>(R.id.item_name_et_cef)
    val new_exp_amount = itemView.findViewById<EditText>(R.id.item_amount_et_cef)
    val exp_name = itemView.findViewById<TextView>(R.id.exp_name_tv_tervi)
    val exp_amount = itemView.findViewById<TextView>(R.id.amount_tv_tervi)
}

