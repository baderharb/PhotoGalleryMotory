package baderharb.motory.photogallerymotory.ui.home

import baderharb.motory.photogallerymotory.data.models.CategoryItem

class CategoriesFactory {
    companion object {
        fun getCategories(): ArrayList<CategoryItem> {
            val categories = ArrayList<CategoryItem>()
            categories.add(CategoryItem(title = "Images", isSelected = true))
            categories.add(CategoryItem(title = "My Favorites", isSelected = false))
            return categories
        }
    }
}