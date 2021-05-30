package com.bohdanhub.data.repository

import com.bohdanhub.data.repository.auth.AuthRepositoryImpl
import com.bohdanhub.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {

    @Binds
    fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}