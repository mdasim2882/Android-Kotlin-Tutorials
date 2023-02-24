package com.example.viewmodelapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

// Since activity is recreated on rotation, that's why we use ViewModel to
// preserve the data

class MainActivity : AppCompatActivity() {
    lateinit var txtCounter: TextView
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this)
            .get(MainViewModel::class.java)

        txtCounter = findViewById(R.id.textView)
        setText()
    }

    fun increment(view: View) {
        mainViewModel.increment()
        setText()
    }

    fun setText() {
        txtCounter.text = mainViewModel.count.toString()
    }

    fun goAhead(view: View) {
        Intent(this, TestActivity::class.java).also {
            startActivity(it)
        }
    }

}