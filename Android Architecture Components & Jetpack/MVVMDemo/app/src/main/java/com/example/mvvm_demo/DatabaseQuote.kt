package com.example.mvvm_demo

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [QuoteEntity::class], version = 1)
abstract class DatabaseQuote : RoomDatabase() {



    // For getting reference of quote table
    abstract fun quoteDao(): DaoQuote

    companion object {

        private var INSTANCE: DatabaseQuote? = null
        private const val DATABASE_NAME ="quote_database"
        fun getDatabase(context: Context): DatabaseQuote {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context,
                        DatabaseQuote::class.java,
                        DATABASE_NAME
                    )
                        .createFromAsset("quotes.db")
                        .build()
                }
            }
            return INSTANCE!!
        }

    }
}