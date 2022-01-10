package com.gdsc.expensetracker.CategoryExpense

import android.icu.util.CurrencyAmount
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gdsc.expensetracker.CategoryExpense.RecyclerView.CategoryExpenseRVAdapter
import com.gdsc.expensetracker.R
import com.gdsc.expensetracker.Room.Item
import com.gdsc.expensetracker.Room.ItemViewModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class CategoryExpenseFragment : Fragment() {

    companion object {
        fun newInstance() = CategoryExpenseFragment()
    }
    var category = "Stationary"

    private lateinit var viewModel: CategoryExpenseViewModel
    private lateinit var itemViewModel: ItemViewModel
    private val args: CategoryExpenseFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.category_expense_fragment, container, false)

        val adapter = CategoryExpenseRVAdapter()
        val rv = view.findViewById<RecyclerView>(R.id.rv_cef)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())
        // fetch data
        itemViewModel = ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)
        itemViewModel.readAllData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            adapter.setData(it)
        })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var name = args.categoryName
        var ImageResource = when(name){
            "Food" -> R.drawable.food_icon
            "Laundry" -> R.drawable.laundry_icon
            "Stationary" -> R.drawable.stationary_icon
            "Groceries" -> R.drawable.grocery_icon
            "Clothes" -> R.drawable.clothes_icon
            "Hygiene" -> R.drawable.hygiene_icon
            "Electronics" -> R.drawable.electronics_icon
            else -> R.drawable.others_icon
        }
        view.findViewById<ImageView>(R.id.bg_image_cef).setImageResource(ImageResource)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val addItemButton = view?.findViewById<CardView>(R.id.add_item_btn_cef)

        viewModel = ViewModelProvider(this).get(CategoryExpenseViewModel::class.java)
        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        addItemButton!!.setOnClickListener {
            insertDataToDataBase()
        }

    }

    private fun insertDataToDataBase() {
        val itemNameET = view?.findViewById<EditText>(R.id.item_name_et_cef)
        val itemAmountET = view?.findViewById<EditText>(R.id.item_amount_et_cef)
        val df: DateFormat = SimpleDateFormat("EEE, d MMM yyyy, HH:mm")

        val _itemName = itemNameET?.text.toString()
        val _itemPrice = itemAmountET?.text.toString()
        val dateAndTime = df.format(Calendar.getInstance().time).toString()

        if(inputCheck(_itemName,_itemPrice)){
            //Creating Item object
            val item = Item(0, itemName = _itemName, itemPrice = Integer. parseInt(_itemPrice), category = category, DateAndTime = dateAndTime)
            itemViewModel.addItem(item)
            Toast.makeText(requireContext(),"${_itemName} has been successfully added to the list", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(requireContext(),"Please make sure all fields are filled in correctly.", Toast.LENGTH_SHORT).show()
        }

    }
private fun inputCheck(name: String, amount: String): Boolean {
    return !(TextUtils.isEmpty(name) || TextUtils.isEmpty(amount))
}
}




//Various date and time formats

//"yyyy.MM.dd G 'at' HH:mm:ss z" ---- 2001.07.04 AD at 12:08:56 PDT
//"hh 'o''clock' a, zzzz" ----------- 12 o'clock PM, Pacific Daylight Time
//"EEE, d MMM yyyy HH:mm:ss Z"------- Wed, 4 Jul 2001 12:08:56 -0700   <-------------In use rn
//"yyyy-MM-dd'T'HH:mm:ss.SSSZ"------- 2001-07-04T12:08:56.235-0700
//"yyMMddHHmmssZ"-------------------- 010704120856-0700
//"K:mm a, z" ----------------------- 0:08 PM, PDT
//"h:mm a" -------------------------- 12:08 PM
//"EEE, MMM d, ''yy" ---------------- Wed, Jul 4, '01