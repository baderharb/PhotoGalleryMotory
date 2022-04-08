package baderharb.motory.photogallerymotory.data.networking

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val req = chain.request()
            .newBuilder().addHeader("Authorization", "JuMyjQzhPjB2Wm2-sCzlNiLmrOV4qtkTaHU57K_XyXk")
            .build()
        return chain.proceed(req)
    }
}