package Network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("auth/register.php")
    fun register(@Body request: RegisterRequest): Call<AuthResponse>

    @POST("auth/login.php")
    fun login(@Body request: LoginRequest): Call<AuthResponse>

    @GET("admin/stickers/list.php")
//    fun getAllStickers(): Call<StickerListResponse>

    @POST("admin/stickers/add.php")
    fun addSticker()
//        @Body request: AddStickerRequest
//    ): Call<BasicResponse>

//    @POST("admin/stickers/update.php")
//    fun updateSticker(
//        @Body request: UpdateStickerRequest
////    ): Call<BasicResponse>
//
//    @GET("admin/stickers/delete.php")
//    fun deleteSticker(
//        @Query("id") id: Int
//    ): Call<BasicResponse>
}