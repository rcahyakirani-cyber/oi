package com.example.stikerrli

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.stikerrli.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // NAVIGASI: Pindah ke Register
        binding.TextRegis.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // LOGIC: Tombol Login
        binding.ButtonRegis.setOnClickListener {
            val username = binding.UsernameRegis.text.toString()
            val password = binding.PasswordRegis.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Isi semua data!", Toast.LENGTH_SHORT).show()
            } else {
                loginUser(username, password)
            }
        }
    }

    private fun loginUser(username: String, password: String) {
        class LoginProcess : AsyncTask<Void, Void, String>() {
            override fun doInBackground(vararg voids: Void?): String {
                val params = HashMap<String, String>()
                params["name"] = username
                params["password"] = password

                val rh = RequestHandler()
                return rh.sendPostRequest(Konfigurasi.URL_LOGIN, params)
            }

            override fun onPostExecute(s: String) {
                super.onPostExecute(s)
                try {
                    val jsonObject = JSONObject(s)
                    if (jsonObject.getString("status") == "success") {
                        startActivity(Intent(this@MainActivity, HomePage::class.java))
                        finish()
                    } else {
                        Toast.makeText(this@MainActivity, jsonObject.getString("message"), Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
        LoginProcess().execute()
    }
}