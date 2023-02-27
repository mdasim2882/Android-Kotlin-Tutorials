package com.example.viewmodelfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var txtCounter: TextView
    lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Requesting ViewModelProvider to use my MainViewModel class and
        // this MainViewModelFactory to create an object for me
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(10))
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