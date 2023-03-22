package com.example.bindingexamplelivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

   val liveData = MutableLiveData("What you give is what you get")

    fun updateData(){
        liveData.value = "You'll see it when you believe it"
    }
}