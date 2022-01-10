package com.gdsc.expensetracker.CategoryExpense.RecyclerView

import android.app.AlertDialog
import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.gdsc.expensetracker.CategoryExpense.CategoryExpenseFragment
import com.gdsc.expensetracker.CategoryList.RecyclerView.CategoryViewHolder
import com.gdsc.expensetracker.R
import com.gdsc.expensetracker.Room.Item
import com.gdsc.expensetracker.Room.ItemViewModel
import java.util.stream.DoubleStream.builder

class CategoryExpenseRVAdapter: RecyclerView.Adapter<CategoryExpViewHolder>() {
    var expenditures = ArrayList<Item>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryExpViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.today_exp_rv_item,parent,false)
        return CategoryExpViewHolder(view)
    }


    override fun getItemCount(): Int {
        return expenditures.size
    }

    override fun onBindViewHolder(holder: CategoryExpViewHolder, position: Int) {
//        val itemViewModel = ViewModelProvider(holder.itemView.context).get(ItemViewModel::class.java)
        var expenditure = expenditures[position]
        holder.exp_name.text = expenditure.itemName
        holder.exp_amount.text = expenditure.itemPrice.toString()

        holder.delete.setOnClickListener {
            val builder = AlertDialog.Builder(holder.itemView.context,)
            builder.setPositiveButton("Yes"){_,_ ->
//                itemViewModel.deleteItem(expenditure)
                Toast.makeText(
                    holder.itemView.context, "${expenditure.itemName} has been removed",Toast.LENGTH_SHORT).show()

            }
            builder.setNegativeButton("No"){_,_->}
            builder.setTitle("Delete ${expenditure.itemName}")
            builder.setMessage("Are you sure you want to delete ${expenditure.itemName}")
            builder.create().show()
        }




    }
    fun setData(item : List<Item>){
        this.expenditures = item as ArrayList<Item>
        notifyDataSetChanged()

    }


}

class CategoryExpViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val new_exp_name = itemView.findViewById<EditText>(R.id.item_name_et_cef)
    val new_exp_amount = itemView.findViewById<EditText>(R.id.item_amount_et_cef)
    val exp_name = itemView.findViewById<TextView>(R.id.exp_name_tv_tervi)
    val exp_amount = itemView.findViewById<TextView>(R.id.amount_tv_tervi)
    val delete =itemView.findViewById<ImageView>(R.id.close_tervi)
    val icon = itemView.findViewById<ImageView>(R.id.cat_image_tervi)
}

