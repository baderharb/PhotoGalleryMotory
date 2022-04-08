package baderharb.motory.photogallerymotory.data.home

import baderharb.motory.photogallerymotory.data.models.PhotoItem

interface PhotosDataSource {
    suspend fun getPhotos(): MutableList<PhotoItem>?
}