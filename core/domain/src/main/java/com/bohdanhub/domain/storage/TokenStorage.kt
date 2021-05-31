package com.bohdanhub.domain.storage

import com.bohdanhub.domain.entity.auth.AccessToken

interface TokenStorage {
    fun saveToken(accessToken: AccessToken)

    fun getToken(): AccessToken
}