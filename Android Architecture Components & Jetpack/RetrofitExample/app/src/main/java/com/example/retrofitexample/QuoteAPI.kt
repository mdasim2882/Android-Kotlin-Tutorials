package com.example.retrofitexample

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


// Retrofit will provide the implementation of these functions automatically
interface QuoteAPI {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): Response<QuoteList>

    // BASE_URL + /quotes?page=1
    // @Query("page") denotes the query parameter here similar to ?page=1
}