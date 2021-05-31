package com.bohdanhub.data.network

import com.bohdanhub.data.network.api.AuthApi
import com.bohdanhub.share.di.scopes.PerApplication
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object ApiModule {
    @JvmStatic
    @Provides
    @PerApplication
    fun provideNetworkApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)
}