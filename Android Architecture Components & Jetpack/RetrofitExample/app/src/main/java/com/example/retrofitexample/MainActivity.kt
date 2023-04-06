package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Attaching Retrofit Instance with QuoteAPI interface
        val retrofit = RetrofitHelper.getInstance().create(QuoteAPI::class.java)

        // Global scope is used to launch top-level coroutines
        // which are operating on the whole application lifetime and are not cancelled prematurely.
        // Here, we're using Coroutine to make a network call
        GlobalScope.launch() {

            val result = retrofit.getQuotes(1)
            result?.also { response ->
                Log.d(TAG, "onCreate: " + response.body().toString())

                val quoteList = response.body()
                quoteList?.also { listOfQuotes ->
                    listOfQuotes.results.forEach {
                        Log.d(TAG, "onCreate: " + it.content)
                    }
                }
            }
        }
    }
}