package com.example.mvvm_demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModeFactory(private val quoteRepositoryModel: QuoteRepositoryModel) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(quoteRepositoryModel) as T
    }
}

