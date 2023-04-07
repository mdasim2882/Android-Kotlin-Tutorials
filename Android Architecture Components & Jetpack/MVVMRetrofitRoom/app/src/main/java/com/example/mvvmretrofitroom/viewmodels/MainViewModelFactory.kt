package com.example.mvvmretrofitroom.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitroom.repository.QuoteRepository

// Whenever we want to include arguments in our ViewModel classes,
// we'll always use ViewModelFactory
class MainViewModelFactory(private val quoteRepository: QuoteRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(quoteRepository) as T
    }
}
