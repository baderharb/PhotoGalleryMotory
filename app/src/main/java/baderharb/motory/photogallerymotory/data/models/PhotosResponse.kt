package baderharb.motory.photogallerymotory.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoItem(
    @Json(name = "blur_hash")
    val blur_hash: String?,
    @Json(name = "color")
    val color: String?,
    @Json(name = "created_at")
    val created_at: String?,
    @Json(name = "current_user_collections")
    val current_user_collections: List<CurrentUserCollection>?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "height")
    val height: Int?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "liked_by_user")
    val liked_by_user: Boolean?,
    @Json(name = "likes")
    val likes: Int?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "updated_at")
    val updated_at: String?,
    @Json(name = "urls")
    val urls: Urls?,
    @Json(name = "user")
    val user: User?,
    @Json(name = "width")
    val width: Int?
)

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "bio")
    val bio: String?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "instagram_username")
    val instagram_username: String?,
    @Json(name = "links")
    val links: LinksX?,
    @Json(name = "location")
    val location: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "portfolio_url")
    val portfolio_url: String?,
    @Json(name = "profile_image")
    val profile_image: ProfileImage,
    @Json(name = "total_collections")
    val total_collections: Int?,
    @Json(name = "total_likes")
    val total_likes: Int?,
    @Json(name = "total_photos")
    val total_photos: Int?,
    @Json(name = "twitter_username")
    val twitter_username: String?,
    @Json(name = "username")
    val username: String?
)

@JsonClass(generateAdapter = true)
data class Urls(
    @Json(name = "full")
    val full: String?,
    @Json(name = "raw")
    val raw: String?,
    @Json(name = "regular")
    val regular: String?,
    @Json(name = "small")
    val small: String?,
    @Json(name = "thumb")
    val thumb: String?
)

@JsonClass(generateAdapter = true)
data class ProfileImage(
    @Json(name = "large")
    val large: String?,
    @Json(name = "medium")
    val medium: String?,
    @Json(name = "small")
    val small: String?
)

@JsonClass(generateAdapter = true)
data class Links(
    @Json(name = "download")
    val download: String?,
    @Json(name = "download_location")
    val download_location: String?,
    @Json(name = "html")
    val html: String?,
    @Json(name = "self")
    val self: String?
)

@JsonClass(generateAdapter = true)
data class LinksX(
    @Json(name = "html")
    val html: String?,
    @Json(name = "likes")
    val likes: String?,
    @Json(name = "photos")
    val photos: String?,
    @Json(name = "portfolio")
    val portfolio: String?,
    @Json(name = "self")
    val self: String?
)

@JsonClass(generateAdapter = true)
data class CurrentUserCollection(
    @Json(name = "cover_photo")
    val cover_photo: Any?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "last_collected_at")
    val last_collected_at: String?,
    @Json(name = "published_at")
    val published_at: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "updated_at")
    val updated_at: String?,
    @Json(name = "user")
    val user: Any?
)
