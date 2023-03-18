package com.example.quotifyusingviewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(val context: Context) : ViewModel() {

    private var quoteList: Array<Quote> = emptyArray()
    private var index = 0

    init {
        quoteList = loadQuotesFromAssets()
    }

    fun nextQuote() = quoteList[++index]
    fun getQuote() = quoteList[index]
    fun prevQuote() = quoteList[--index]

    private fun loadQuotesFromAssets(): Array<Quote> {


        // Reading data from quotes.json
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        // Storing data in json format
        val json = String(buffer, Charsets.UTF_8)

        // Converting to Java Array
        val gson = Gson()
        return gson.fromJson(json, Array<Quote>::class.java)
    }
}