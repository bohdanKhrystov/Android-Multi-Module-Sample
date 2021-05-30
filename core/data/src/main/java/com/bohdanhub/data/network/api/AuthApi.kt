package com.bohdanhub.data.network.api

import com.bohdanhub.data.BuildConfig
import com.bohdanhub.data.network.model.auth.TokenResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthApi {
    @GET("login/oauth/access_token")
    suspend fun getAccessToken(
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("code") code: String
    ): Response<TokenResponse>

    companion object {
        fun buildAuthUrl(): String {
            return "${BuildConfig.SERVER_URL}/login/oauth/authorize?client_id=${BuildConfig.CLIENT_ID}"
        }
    }
}