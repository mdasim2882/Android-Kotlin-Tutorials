package com.example.lifecycleawarecomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(Observer())
        Log.d(TAG, "onCreate: called in MainActivity")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: called in $TAG")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: called in $TAG")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: called in $TAG")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: called in $TAG")

    }
}