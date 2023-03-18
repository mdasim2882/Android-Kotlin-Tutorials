package com.example.quotifyusingviewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    private val quoteText: TextView
        get() = findViewById(R.id.quoteText)
    private val quoteAuthor: TextView
        get() = findViewById(R.id.quoteAuthor)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(applicationContext))
            .get(MainViewModel::class.java)

        setQuote(mainViewModel.getQuote())

    }

    fun setQuote(quote :Quote){
        quoteText.text= quote.text
        quoteAuthor.text= quote.author
    }

    fun onNext(view: View) = setQuote(mainViewModel.nextQuote())

    fun onPrevious(view: View) = setQuote(mainViewModel.prevQuote())
    fun onShare(view: View) {
        Intent(Intent.ACTION_SEND).apply {
            setType("text/plain")
            putExtra(Intent.EXTRA_TEXT,mainViewModel.getQuote().text)
            startActivity(this)
        }
    }


}