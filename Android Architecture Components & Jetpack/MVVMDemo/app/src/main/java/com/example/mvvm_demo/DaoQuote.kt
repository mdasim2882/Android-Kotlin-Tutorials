package com.example.mvvm_demo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface DaoQuote {

    @Query("SELECT * FROM quote")
    fun getQuotes(): LiveData<List<QuoteEntity>>

    @Insert
    suspend fun insertQuote(quote: QuoteEntity)
}