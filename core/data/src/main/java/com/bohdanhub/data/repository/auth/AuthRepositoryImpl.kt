package com.bohdanhub.data.repository.auth

import com.bohdanhub.data.model.auth.TokenResponse
import com.bohdanhub.data.network.api.AuthApi
import com.bohdanhub.data.network.util.handleResponse
import com.bohdanhub.domain.entity.auth.AccessToken
import com.bohdanhub.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi
) : AuthRepository {

    override suspend fun getAccessToken(code: String): AccessToken {
        val response: TokenResponse =
            handleResponse(
                api.getAccessToken(
                    code = code
                )
            )
        return AccessToken(response.accessToken)
    }
}