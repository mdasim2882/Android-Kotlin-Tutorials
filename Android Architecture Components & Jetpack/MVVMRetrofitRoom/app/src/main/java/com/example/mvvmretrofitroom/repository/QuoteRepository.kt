package com.example.mvvmretrofitroom.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmretrofitroom.api.QuoteAPIService
import com.example.mvvmretrofitroom.models.QuoteList
import retrofit2.Response

class QuoteRepository(private val quoteAPIService: QuoteAPIService) {

    private val quotesLiveData = MutableLiveData<QuoteList>()

    val liveData: LiveData<QuoteList>
        get() = quotesLiveData

    // This function is marked as suspend due to network call
    suspend fun getQuotes(page: Int) {
        // NETWORK CALL
        val result = quoteAPIService.getQuotes(page)
        if (result?.body() != null) {
            quotesLiveData.postValue(result.body())
        }
    }
}