package baderharb.motory.photogallerymotory.ui.binding

import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImage(view: AppCompatImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(url)
            .into(view)
    }
}

@BindingAdapter("app:tint")
fun AppCompatImageView.setImageTint(@ColorInt color: Int) {
    setColorFilter(color)
}