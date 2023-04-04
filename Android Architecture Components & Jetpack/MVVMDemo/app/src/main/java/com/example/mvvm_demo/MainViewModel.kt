package com.example.mvvm_demo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(private val quoteRepository: QuoteRepositoryModel) : ViewModel() {

    fun getQuotes(): LiveData<List<QuoteEntity>> {
        return quoteRepository.getQuote()
    }

    fun insertQuote(quote: QuoteEntity) {
        viewModelScope.launch((Dispatchers.IO))
        {
            quoteRepository.insertQuote(quote)
        }
    }

}