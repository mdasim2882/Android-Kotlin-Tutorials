package com.example.bindingexamplelivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bindingexamplelivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.mainViewModel = mainViewModel
        binding.lifecycleOwner= this

//        REPLACING this liveData observing by @{mainViewModel.liveData} in activity_main.xml
//        mainViewModel.liveData.observe(this, Observer {
//            binding.quoteText.text = it
//        })

//        REPLACING this button click by @{()->mainViewModel.update} in activity_main.xml
//        binding.updateButton.setOnClickListener {
//            mainViewModel.updateData()
//        }

        // THIS EXAMPLE ALSO USES TWO-WAY DATA BINDING in activity_main.xml


    }
}