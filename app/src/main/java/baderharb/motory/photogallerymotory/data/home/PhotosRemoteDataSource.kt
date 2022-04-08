package baderharb.motory.photogallerymotory.data.home

import android.util.Log
import baderharb.motory.photogallerymotory.data.models.PhotoItem
import baderharb.motory.photogallerymotory.data.networking.ApiEndpoints

private const val TAG = "PhotosRemoteDataSource"

class PhotosRemoteDataSource(private val endpoints: ApiEndpoints) : PhotosDataSource {

    override suspend fun getPhotos(): MutableList<PhotoItem>? {
        val response = endpoints.getPhotos("JuMyjQzhPjB2Wm2-sCzlNiLmrOV4qtkTaHU57K_XyXk")
        return if (response.isSuccessful) {
            val body = response.body()
            if (body == null || response.code() == 204) {
                null
            } else {
                body
            }
        } else {
            null
        }
    }
}