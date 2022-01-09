package com.gdsc.expensetracker.TodayExpenseList.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gdsc.expensetracker.CategoryExpense.RecyclerView.CategoryExpViewHolder
import com.gdsc.expensetracker.CategoryExpense.RecyclerView.CategoryExpenseRVItem
import com.gdsc.expensetracker.R

class TodayExpenseRVAdapter: RecyclerView.Adapter<TodayExpenseViewHolder>()  {
    var expenditures = ArrayList<CategoryExpenseRVItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayExpenseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.today_exp_rv_item,parent,false)
        return TodayExpenseViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodayExpenseViewHolder, position: Int) {
        var expenditure = expenditures[position]
        holder.exp_name.text = expenditure.name
        holder.exp_amount.text = expenditure.amount.toString()
    }

    override fun getItemCount(): Int {
        return expenditures.size
    }
}
class TodayExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val exp_name = itemView.findViewById<TextView>(R.id.exp_name_tv_tervi)
    val exp_amount = itemView.findViewById<TextView>(R.id.amount_tv_tervi)
}

