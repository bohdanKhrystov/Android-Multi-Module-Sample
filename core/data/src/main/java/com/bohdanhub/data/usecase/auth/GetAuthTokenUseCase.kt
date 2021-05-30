package com.bohdanhub.data.usecase.auth

import com.bohdanhub.domain.entity.auth.AccessToken
import com.bohdanhub.domain.entity.auth.TokenRequest
import com.bohdanhub.domain.repository.AuthRepository
import com.bohdanhub.domain.usecase.BaseUseCase
import javax.inject.Inject

class GetAuthTokenUseCase @Inject constructor(
    private val repository: AuthRepository
) : BaseUseCase<TokenRequest, AccessToken> {

    override suspend fun execute(request: TokenRequest): AccessToken {
        return repository.getAccessToken(request.authCode)
    }
}