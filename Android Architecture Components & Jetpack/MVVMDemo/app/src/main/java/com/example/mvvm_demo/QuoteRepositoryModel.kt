package com.example.mvvm_demo

import androidx.lifecycle.LiveData

class QuoteRepositoryModel(private val daoQuote: DaoQuote) {

    fun getQuote(): LiveData<List<QuoteEntity>> {
        return daoQuote.getQuotes()
    }

    suspend fun insertQuote(quoteEntity: QuoteEntity){
        daoQuote.insertQuote(quoteEntity)
    }
}