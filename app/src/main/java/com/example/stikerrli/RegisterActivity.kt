package com.example.stikerrli

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.stikerrli.databinding.ActivityRegisterBinding
import org.json.JSONObject

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // NAVIGASI: Kembali ke Login
        binding.TextRegis.setOnClickListener {
            onBackPressed()
        }

        // LOGIC: Tombol Register
        binding.ButtonRegis.setOnClickListener {
            val user = binding.UsernameRegis.text.toString()
            val pass = binding.PasswordRegis.text.toString()
            val role = binding.RoleRegis.text.toString()

            if (user.isEmpty() || pass.isEmpty() || role.isEmpty()) {
                Toast.makeText(this, "Lengkapi semua field!", Toast.LENGTH_SHORT).show()
            } else {
                registerUser(user, pass, role)
            }
        }
    }

    private fun registerUser(user: String, pass: String, role: String) {
        class RegisterProcess : AsyncTask<Void, Void, String>() {
            override fun doInBackground(vararg voids: Void?): String {
                val params = HashMap<String, String>()
                params["name"] = user
                params["password"] = pass
                params["role"] = role

                val rh = RequestHandler()
                return rh.sendPostRequest(Konfigurasi.URL_REGISTER, params)
            }

            override fun onPostExecute(s: String) {
                super.onPostExecute(s)
                try {
                    val jsonObject = JSONObject(s)
                    Toast.makeText(this@RegisterActivity, jsonObject.getString("message"), Toast.LENGTH_SHORT).show()
                    if (jsonObject.getString("status") == "success") finish()
                } catch (e: Exception) { e.printStackTrace() }
            }
        }
        RegisterProcess().execute()
    }
}