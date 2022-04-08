package baderharb.motory.photogallerymotory.data.home

import org.koin.core.qualifier.named
import org.koin.dsl.module

internal const val KOIN_NAME_PHOTOS_REMOTE = "KOIN_NAME_PHOTOS_REMOTE"

@JvmField
val repoHomeModule = module {

    single<PhotosDataSource>(named(KOIN_NAME_PHOTOS_REMOTE)) {
        PhotosRemoteDataSource(get())
    }

    single<PhotosDataSource> {
        PhotosRepository(get(named(KOIN_NAME_PHOTOS_REMOTE)))
    }
}
