package com.example.samplemvvmapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null
    var authListener:AuthListener? = null
    fun onLoginButtonClick(v: View)
    {
        authListener?.onStarted()
        if( email.isNullOrEmpty() || password.isNullOrEmpty())
        {
            authListener?.onFailure("Invalid email or password")
            // Ask again for input
            return
        }else{
            authListener?.onSuccess()
            // TODO: Authentication logic
        }
    }




}


