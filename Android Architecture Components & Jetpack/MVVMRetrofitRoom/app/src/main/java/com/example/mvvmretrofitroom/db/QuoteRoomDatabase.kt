package com.example.mvvmretrofitroom.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmretrofitroom.models.Result

@Database(entities = [Result::class], version = 1)
abstract class QuoteRoomDatabase : RoomDatabase() {

    abstract fun getRoomDao(): QuoteDaoRoom

    companion object {
        @Volatile
        private var INSTANCE: QuoteRoomDatabase? = null

        fun getDatabase(context: Context): QuoteRoomDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context, QuoteRoomDatabase::class.java,
                        "quoteDb"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}