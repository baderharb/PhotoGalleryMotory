package baderharb.motory.photogallerymotory.data.home

import baderharb.motory.photogallerymotory.data.models.PhotoItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PhotosRepository(private val photosRemoteDataSource: PhotosDataSource) : PhotosDataSource {

    override suspend fun getPhotos(): MutableList<PhotoItem>? {
        return withContext(Dispatchers.IO) {
            photosRemoteDataSource.getPhotos()
        }
    }
}