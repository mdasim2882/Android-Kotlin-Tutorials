package com.example.viewmodelfactory


import androidx.lifecycle.ViewModel

// View Models are Lifecycle aware
// Holds the data for your specific screen(activity) in memory until it is fully destroyed
// Contains any logic or formatting data for your UI
// USECASE: Holding Network calls data

class MainViewModel(val initValue: Int) : ViewModel() {

    // LOGIC
    var count = initValue

    fun increment(){
        count++
    }
}