package com.gdsc.expensetracker.Room

import androidx.lifecycle.LiveData

class ItemRepository(private val itemDao : ItemDao) {
    val readAllData: LiveData<List<Item>> = itemDao.readAllData()

    suspend fun addItem(item: Item){
        itemDao.addItem(item)
    }
    suspend fun deleteItem(item: Item){
        itemDao.deleteItem(item)
    }
}