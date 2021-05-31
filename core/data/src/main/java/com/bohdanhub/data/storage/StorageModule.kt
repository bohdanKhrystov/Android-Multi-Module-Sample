package com.bohdanhub.data.storage

import com.bohdanhub.data.storage.auth.PreferenceTokenStorage
import com.bohdanhub.domain.storage.TokenStorage
import dagger.Binds
import dagger.Module

@Module
interface StorageModule {
    @Binds
    fun bindTokenStorage(preferenceTokenStorage: PreferenceTokenStorage): TokenStorage
}