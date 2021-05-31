package com.bohdanhub.data.usecase

import com.bohdanhub.data.usecase.auth.GetAuthTokenUseCase
import com.bohdanhub.data.usecase.repository.GetAllRepositoriesUseCaseImpl
import com.bohdanhub.data.usecase.user.GetUserUseCase
import com.bohdanhub.domain.entity.auth.AccessToken
import com.bohdanhub.domain.entity.auth.TokenRequest
import com.bohdanhub.domain.entity.repository.AllRepositoriesRequest
import com.bohdanhub.domain.entity.repository.Repository
import com.bohdanhub.domain.entity.user.User
import com.bohdanhub.domain.entity.user.UserRequest
import com.bohdanhub.domain.usecase.BaseUseCase
import com.bohdanhub.domain.usecase.GetAllRepositoriesUseCase
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {

    @Binds
    fun bindGetAuthTokenUseCase(useCase: GetAuthTokenUseCase): BaseUseCase<TokenRequest, AccessToken>

    @Binds
    fun bindGetUserUseCase(useCase: GetUserUseCase): BaseUseCase<UserRequest, User>

    @Binds
    fun bindGetAllRepositoriesUseCase(useCase: GetAllRepositoriesUseCaseImpl): GetAllRepositoriesUseCase
}