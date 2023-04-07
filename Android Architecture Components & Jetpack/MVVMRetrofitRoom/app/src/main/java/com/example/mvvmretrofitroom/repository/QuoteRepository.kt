package com.example.mvvmretrofitroom.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmretrofitroom.api.QuoteAPIService
import com.example.mvvmretrofitroom.db.QuoteDaoRoom
import com.example.mvvmretrofitroom.db.QuoteRoomDatabase
import com.example.mvvmretrofitroom.models.QuoteList
import com.example.mvvmretrofitroom.util.NetworkUtils
import retrofit2.Response

class QuoteRepository(
    private val quoteAPIService: QuoteAPIService,
    private val quoteRoomDatabase: QuoteRoomDatabase,
    private val context: Context
) {

    private val quotesLiveData = MutableLiveData<QuoteList>()

    val liveData: LiveData<QuoteList>
        get() = quotesLiveData

    // This function is marked as suspend due to network call
    suspend fun getQuotes(page: Int) {

        if (NetworkUtils.isInternetAvailable(context)) {
            // NETWORK CALL
            val result = quoteAPIService.getQuotes(page)
            if (result?.body() != null) {
                // Storing in DATABASE
                quoteRoomDatabase.getRoomDao().addQuotes(result.body()!!.results)
                quotesLiveData.postValue(result.body())

            }
        } else {
            val quotes = quoteRoomDatabase.getRoomDao().getQuotes()
            val quoteList = QuoteList(1, 1, 1, quotes, 1, 1)
            quotesLiveData.postValue(quoteList)
        }
    }
}