package com.ramiguev.arhepp.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramiguev.arhepp.R
import com.ramiguev.arhepp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}