package baderharb.motory.photogallerymotory.data.networking

import baderharb.motory.photogallerymotory.BuildConfig
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@JvmField
val remoteModule = module {
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideForecastApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create()).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

fun provideForecastApi(retrofit: Retrofit): ApiEndpoints =
    retrofit.create(ApiEndpoints::class.java)
