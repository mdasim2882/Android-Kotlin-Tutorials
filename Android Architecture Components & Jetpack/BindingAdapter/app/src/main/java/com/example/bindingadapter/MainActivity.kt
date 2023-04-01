package com.example.bindingadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.bindingadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val mImage = "https://developer.alexanderklimov.ru/android/images/android_cat.jpg"
        val post = Post(
            "Scooby Doo",
            "Scooby-Doo is an American media franchise based on an animated television series launched in 1969 and continued through several derivative media",
            mImage
        )
        binding.post = post
    }
}