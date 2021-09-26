package com.ramiguev.arhepp.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramiguev.arhepp.R
import com.ramiguev.arhepp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}