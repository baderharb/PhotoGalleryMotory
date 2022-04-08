package baderharb.motory.photogallerymotory.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

object AppUtils {

    fun openLink(context: Context, link: String) {
        try {
            var url = link
            if (!url.startsWith("https://") && !url.startsWith("http://")) {
                url = "http://$link"
            }

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(browserIntent)
        } catch (ex: Exception) {/*no default app*/
        }
    }

}