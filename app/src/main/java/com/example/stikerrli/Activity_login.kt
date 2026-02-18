package com.example.stikerrli

import Network.ApiService
import Network.AuthResponse
import Network.LoginRequest
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Activity_login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsername = findViewById<EditText>(R.id.UsernameRegis)
        val etPassword = findViewById<EditText>(R.id.PasswordRegis)
        val btnLogin = findViewById<Button>(R.id.ButtonRegis)
        val tvSignUp = findViewById<TextView>(R.id.TextRegis)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val loginRequest = LoginRequest(username, password)
//                val call = ApiService.instance.login(loginRequest)


//                call.enqueue(object : Callback<AuthResponse> {
//                    override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
//                        if (response.isSuccessful) {
//                            val authResponse = response.body()
//                            if (authResponse != null && authResponse.success) {
//                                Toast.makeText(this@Activity_login, "Login Successful", Toast.LENGTH_SHORT).show()
//                                // Ganti HomePage::class.java dengan activity halaman utama Anda
//                                val intent = Intent(this@Activity_login, MainActivity::class.java)
//                                startActivity(intent)
//                                finish()
//                            } else {
//                                Toast.makeText(this@Activity_login, "Login failed: ${authResponse?.message}", Toast.LENGTH_SHORT).show()
//                            }
//                        } else {
//                            Toast.makeText(this@Activity_login, "Login failed: ${response.message()}", Toast.LENGTH_SHORT).show()
//                        }
//                    }
//
//                    override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
//                        Toast.makeText(this@Activity_login, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
//                    }
//                })
            } else {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            }
        }

        tvSignUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
