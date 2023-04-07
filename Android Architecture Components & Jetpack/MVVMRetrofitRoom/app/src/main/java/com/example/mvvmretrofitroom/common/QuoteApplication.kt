package com.example.mvvmretrofitroom.common

import android.app.Application
import com.example.mvvmretrofitroom.api.QuoteAPIService
import com.example.mvvmretrofitroom.api.RetrofitHelper
import com.example.mvvmretrofitroom.db.QuoteRoomDatabase
import com.example.mvvmretrofitroom.repository.QuoteRepository

class QuoteApplication: Application() {

    lateinit var quoteRepository: QuoteRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {

        val quoteAPIService = RetrofitHelper.getInstance().create(QuoteAPIService::class.java)
        val databaseQuote= QuoteRoomDatabase.getDatabase(applicationContext)

        quoteRepository = QuoteRepository(quoteAPIService,databaseQuote,applicationContext )
    }
}