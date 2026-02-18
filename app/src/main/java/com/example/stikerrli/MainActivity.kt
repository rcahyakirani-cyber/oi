package com.example.stikerrli

import android.os.AsyncTask
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.stikerrli.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    // Inisialisasi binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menggunakan ViewBinding untuk memuat layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menggunakan binding untuk mengakses ID dari XML
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
                // Gunakan 'Konfigurasi' dengan huruf kapital sesuai nama object-nya
                return rh.sendPostRequest(Konfigurasi.URL_LOGIN, params)
            }

            override fun onPostExecute(s: String) {
                super.onPostExecute(s)
                try {
                    val jsonObject = JSONObject(s)
                    val status = jsonObject.getString("status")
                    val message = jsonObject.getString("message")

                    if (status == "success") {
                        Toast.makeText(this@MainActivity, "Selamat Datang!", Toast.LENGTH_LONG).show()
                        // Pindah ke halaman Dashboard jika perlu
                    } else {
                        Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        LoginProcess().execute()
    }
}