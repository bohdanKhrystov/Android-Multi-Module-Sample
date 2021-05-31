package com.bohdanhub.data.network.api

import com.bohdanhub.data.BuildConfig
import com.bohdanhub.data.model.auth.TokenResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthApi {

    @GET("login/oauth/access_token")
    suspend fun getAccessToken(
        @Query("client_id") clientId: String = BuildConfig.CLIENT_ID,
        @Query("client_secret") clientSecret: String = BuildConfig.CLIENT_SECRET,
        @Query("code") code: String
    ): Response<TokenResponse>

    companion object {
        fun buildAuthUrl(): String {
            return "${BuildConfig.GITHUB_COM}/login/oauth/authorize?client_id=${BuildConfig.CLIENT_ID}"
        }
    }
}