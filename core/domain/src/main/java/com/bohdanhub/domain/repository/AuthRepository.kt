package com.bohdanhub.domain.repository

import com.bohdanhub.domain.entity.auth.AccessToken

interface AuthRepository {

    suspend fun getAccessToken(code: String): AccessToken
}