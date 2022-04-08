package baderharb.motory.photogallerymotory.ui.home

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import baderharb.motory.photogallerymotory.data.models.CategoryItem
import baderharb.motory.photogallerymotory.databinding.ItemViewCategoryBinding

class CategoryAdapter() : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var rvHandler: Handler = Handler(Looper.getMainLooper())
    private val categories: MutableList<CategoryItem> = mutableListOf()

    inner class ViewHolder(val binding: ItemViewCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemViewCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(categories?.get(position)) {
                this?.let {
                    binding.title = this.title
                    binding.isSelected = this.isSelected
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return categories.size ?: 0
    }

    fun setItems(items: List<CategoryItem>) {
        rvHandler.post {
            categories.addAll(items)
            notifyItemRangeInserted(/*positionStart*/categories.size,/*itemCount*/ items.size)
        }
    }

    fun clear() {
        rvHandler.post {
            categories.clear()
            notifyDataSetChanged()
        }
    }
}