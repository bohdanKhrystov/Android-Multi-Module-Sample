package com.bohdanhub.data.repository

import com.bohdanhub.data.repository.auth.AuthRepositoryImpl
import com.bohdanhub.data.repository.user.UserRepositoryImpl
import com.bohdanhub.domain.repository.AuthRepository
import com.bohdanhub.domain.repository.UserRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {

    @Binds
    fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}