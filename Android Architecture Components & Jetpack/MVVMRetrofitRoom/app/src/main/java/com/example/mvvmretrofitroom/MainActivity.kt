package com.example.mvvmretrofitroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitroom.api.QuoteAPIService
import com.example.mvvmretrofitroom.api.RetrofitHelper
import com.example.mvvmretrofitroom.common.QuoteApplication
import com.example.mvvmretrofitroom.repository.QuoteRepository
import com.example.mvvmretrofitroom.viewmodels.MainViewModel
import com.example.mvvmretrofitroom.viewmodels.MainViewModelFactory

// VIEW LAYER
class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Since QuoteRepository is accessed by different VieModels,
        // so we'll define at common location as QuoteApplication.kt
        val repository = (application as QuoteApplication).quoteRepository

        viewModel = ViewModelProvider(this, MainViewModelFactory(repository))
            .get(MainViewModel::class.java)

        viewModel.quoteLiveData.observe(this, Observer {
            Toast.makeText(this@MainActivity, it.results.size.toString(), Toast.LENGTH_SHORT).show()
            it.results.forEach { result ->
            Log.d(TAG, "onCreate: ${result.toString()}")
        }})


    }
}