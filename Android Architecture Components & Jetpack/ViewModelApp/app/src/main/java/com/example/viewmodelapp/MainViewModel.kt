package com.example.viewmodelapp

import androidx.lifecycle.ViewModel

// View Models are Lifecycle aware
// Holds the data for your specific screen(activity) in memory until it is fully destroyed
// Contains any logic or formatting data for your UI
// USECASE: Holding Network calls data

class MainViewModel : ViewModel() {

     // LOGIC
    var count = 0

    fun increment(){
        count++
    }
}