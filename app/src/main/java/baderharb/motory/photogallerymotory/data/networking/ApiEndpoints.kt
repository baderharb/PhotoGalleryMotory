package baderharb.motory.photogallerymotory.data.networking

import baderharb.motory.photogallerymotory.data.models.PhotoItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndpoints {

    @GET("/photos")
    suspend fun getPhotos(@Query("client_id") access: String): Response<MutableList<PhotoItem>>
}