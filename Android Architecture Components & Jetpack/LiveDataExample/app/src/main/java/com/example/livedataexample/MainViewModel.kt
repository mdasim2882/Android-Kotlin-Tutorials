package com.example.livedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

//    We need to keep it safe(PRIVATE), so that no one other than us would change this data
//    val factsLiveData = MutableLiveData<String>("This is a fact");

    private val factsLiveDataObject = MutableLiveData<String>("This is a fact")

    // Here it is publicly exposed, but it's again immutable due to LiveData nature
    val factsLiveData: LiveData<String>
        get() = factsLiveDataObject

    fun updateData() {
        factsLiveDataObject.value = "Another Fact"
    }

}
