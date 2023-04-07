package com.example.mvvmretrofitroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitroom.api.QuoteAPIService
import com.example.mvvmretrofitroom.api.RetrofitHelper
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

        val quoteAPIService = RetrofitHelper.getInstance().create(QuoteAPIService::class.java)
        val repository = QuoteRepository(quoteAPIService)

        viewModel = ViewModelProvider(this, MainViewModelFactory(repository))
            .get(MainViewModel::class.java)

        viewModel.quoteLiveData.observe(this, Observer {
            it.results.forEach { result ->
                Log.d("MainActivity", "onCreate:${result.content}")
            }
        })

    }
}