package baderharb.motory.photogallerymotory.ui.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import baderharb.motory.photogallerymotory.data.home.PhotosDataSource
import baderharb.motory.photogallerymotory.data.models.CategoryItem
import baderharb.motory.photogallerymotory.data.models.PhotoItem
import kotlinx.coroutines.launch

private const val TAG = "HomeViewModel"

class HomeViewModel(private val photosDataSource: PhotosDataSource, application: Application) :
    AndroidViewModel(application) {

    private val _message = MutableLiveData<String>()
    var message: MutableLiveData<String> = _message

    private val _categories = MutableLiveData<MutableList<CategoryItem>>()
    var categories: MutableLiveData<MutableList<CategoryItem>> = _categories

    private val _photos = MutableLiveData<MutableList<PhotoItem>?>()
    var photos: MutableLiveData<MutableList<PhotoItem>?> = _photos

    init {
        getPhotos()
        getCategories()
    }

    private fun getCategories() {
        _categories.value = CategoriesFactory.getCategories()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            val result = photosDataSource.getPhotos()
            _photos.value = result
        }
    }
}