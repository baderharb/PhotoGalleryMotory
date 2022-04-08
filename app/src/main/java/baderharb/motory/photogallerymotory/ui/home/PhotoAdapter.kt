package baderharb.motory.photogallerymotory.ui.home

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import baderharb.motory.photogallerymotory.data.models.PhotoItem
import baderharb.motory.photogallerymotory.databinding.ItemViewPhotoBinding

class PhotoAdapter() : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    private var rvHandler: Handler = Handler(Looper.getMainLooper())
    private val photos: MutableList<PhotoItem> = mutableListOf()

    inner class ViewHolder(val binding: ItemViewPhotoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemViewPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(photos[position]) {
                this.let {
                    binding.desc = this.description
                    binding.title = this.user?.name
                    binding.image = this.urls?.regular
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return photos.size ?: 0
    }

    fun setItems(items: List<PhotoItem>) {
        rvHandler.post {
            photos.addAll(items)
            notifyItemRangeInserted(/*positionStart*/photos.size,/*itemCount*/ items.size)
        }
    }

    fun clear() {
        rvHandler.post {
            photos.clear()
            notifyDataSetChanged()
        }
    }
}