package com.example.stikerrli

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.stikerrli.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}