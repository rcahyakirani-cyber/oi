package Network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

// --- LANGKAH 3: Membuat Data Class & Interface ---

// Data yang dikirim ke API (sesuaikan dengan API teman Anda)
data class LoginRequest(
    val username: String,
    val password: String
)

// Data yang diterima dari API (sesuaikan dengan JSON dari API teman Anda)
data class LoginResponse(
    val status: String,
    val message: String,
    val token: String? = null
)

// Interface untuk mendefinisikan endpoint
//interface ApiServ[ice {
//    @POST("login") // Ini adalah endpoint (misal: https://api.com/login)
//    fun loginUser(@Body request: LoginRequest): Call<LoginResponse>
//}

// --- LANGKAH 4: Inisialisasi Retrofit ---

object RetrofitClient {
    // GANTI URL INI dengan URL dari teman Anda (harus diakhiri dengan /)
    private const val BASE_URL = "https://api.example.com/"

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
}
