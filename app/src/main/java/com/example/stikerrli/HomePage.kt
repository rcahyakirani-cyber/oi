package com.example.stikerrli

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.stikerrli.databinding.ActivityHomepageBinding

class HomePage : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}