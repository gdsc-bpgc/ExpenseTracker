package com.gdsc.expensetracker.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version =1, exportSchema = false)
abstract class ItemDataBase : RoomDatabase() {

    abstract fun ItemDao() : ItemDao

    companion object{
        @Volatile
        private var INSTANCE: ItemDataBase? = null
        //creating singleton of db

        fun getDatabase(context: Context) : ItemDataBase{
            val tempInstance = INSTANCE
            //Checking if instance of RoomDB is present or not
            if(tempInstance != null){
                return tempInstance
            }
            //In case it is not present
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDataBase::class.java,
                    "item_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}