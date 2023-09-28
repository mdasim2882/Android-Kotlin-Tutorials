package com.example.samplemvvmapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null


    fun onLoginButtonClick(v: View)
    {
        if( email.isNullOrEmpty() || password.isNullOrEmpty())
        {
            // Ask again for input
            return
        }else{
            // TODO: Authentication logic
        }
    }




}


