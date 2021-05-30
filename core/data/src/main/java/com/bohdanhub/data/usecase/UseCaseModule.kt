package com.bohdanhub.data.usecase

import com.bohdanhub.data.usecase.auth.GetAuthTokenUseCase
import com.bohdanhub.domain.entity.auth.AccessToken
import com.bohdanhub.domain.entity.auth.TokenRequest
import com.bohdanhub.domain.usecase.BaseUseCase
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {

    @Binds
    fun bindGetAuthTokenUseCase(getAuthTokenUseCase: GetAuthTokenUseCase): BaseUseCase<TokenRequest, AccessToken>
}