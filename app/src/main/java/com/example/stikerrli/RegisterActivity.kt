package com.example.stikerrli

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.stikerrli.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ButtonRegis.setOnClickListener {
            val username = binding.UsernameRegis.text.toString()
            val password = binding.PasswordRegis.text.toString()
            // Jika ada field Role di layout activity_register.xml
            // val role = binding.RoleRegis.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Proses register di sini
                Toast.makeText(this, "Registration logic goes here", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.TextRegis.setOnClickListener {
            // Kembali ke LoginActivity (atau MainActivity sesuai alur Anda)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}