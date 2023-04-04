package com.example.mvvm_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = DatabaseQuote.getDatabase(applicationContext).quoteDao()
        val repositoryModel = QuoteRepositoryModel(dao)

        val mainViewModel = ViewModelProvider(this, MainViewModeFactory(repositoryModel))
            .get(MainViewModel::class.java)

        mainViewModel.getQuotes().observe(this, Observer {
            binding.quote = it.toString()
        })
        binding.btnUpdate.setOnClickListener {
            val quote = QuoteEntity(0,"This is testing text.", "Tester")
            mainViewModel.insertQuote(quote)
        }
    }
}