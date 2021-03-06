package com.bohdanhub.data.network.interceptor

import com.bohdanhub.domain.storage.TokenStorage
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeadersInterceptor @Inject constructor(
    private val storage: TokenStorage
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val req = chain.request().newBuilder()
            .addHeader("Authorization", "token ${storage.getToken().token}")
            .addHeader("Accept", "application/vnd.github.v3+json")
            .build()
        return chain.proceed(req)
    }
}