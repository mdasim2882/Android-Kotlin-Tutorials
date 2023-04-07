package com.example.mvvmretrofitroom.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmretrofitroom.models.Result

@Dao
interface QuoteDaoRoom {

    // Take the list of Result and fill the table with the
    // contents of each result instance
    @Insert
    suspend fun addQuotes(quotes: List<Result>)

    @Query("SELECT * from quotes")
    suspend fun getQuotes() :List<Result>


}