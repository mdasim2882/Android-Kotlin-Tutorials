package com.example.lifecycleawarecomponents

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class Observer : DefaultLifecycleObserver {
    val TAG = javaClass.simpleName

    override fun onCreate(owner: LifecycleOwner) {
        Log.d(TAG, "onCreate: called in Observer")
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.d(TAG, "onResume: called in Observer")
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.d(TAG, "onPause: called in Observer")
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d(TAG, "onStop: called in Observer")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.d(TAG, "onDestroy: called in Observer")
    }
}