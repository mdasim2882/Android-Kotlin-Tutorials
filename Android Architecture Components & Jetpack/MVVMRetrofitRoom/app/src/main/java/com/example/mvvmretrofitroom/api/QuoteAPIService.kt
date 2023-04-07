package com.example.mvvmretrofitroom.api

import com.example.mvvmretrofitroom.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// Retrofit will provide the implementation of these functions automatically
interface QuoteAPIService {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): Response<QuoteList>

    // base_url + "/quotes" + ?page=1
    // @Query("page") denotes the query parameter here similar to ?page=1
}