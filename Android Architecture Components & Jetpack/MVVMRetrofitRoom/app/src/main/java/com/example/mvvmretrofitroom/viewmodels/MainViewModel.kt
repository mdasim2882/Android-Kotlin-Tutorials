package com.example.mvvmretrofitroom.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmretrofitroom.models.QuoteList
import com.example.mvvmretrofitroom.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.getQuotes(1)
        }
    }

    val quoteLiveData: LiveData<QuoteList>
        get() = quoteRepository.liveData
}