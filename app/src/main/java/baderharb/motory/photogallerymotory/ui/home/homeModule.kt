package baderharb.motory.photogallerymotory.ui.home

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val homeModule = module {

    viewModel {
        HomeViewModel(get(), get())
    }
    factory {
        CategoryAdapter()
    }
    factory {
        PhotoAdapter()
    }
}
