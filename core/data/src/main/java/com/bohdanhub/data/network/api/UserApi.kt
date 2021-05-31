package com.bohdanhub.data.network.api

import com.bohdanhub.data.model.repository.RepositoryResponse
import com.bohdanhub.data.model.user.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("user")
    suspend fun getUser(): Response<UserResponse>

    @GET("users/{username}/repos")
    suspend fun getAllRepositories(@Path("username") userName: String): Response<List<RepositoryResponse>>
}