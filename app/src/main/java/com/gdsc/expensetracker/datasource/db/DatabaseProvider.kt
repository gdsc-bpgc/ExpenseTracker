package com.gdsc.expensetracker.datasource.db

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    private lateinit var instance: AppDatabase

    @Synchronized
    operator fun invoke(context: Context): AppDatabase {
        if (!::instance.isInitialized) {

            instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
        return instance
    }
}