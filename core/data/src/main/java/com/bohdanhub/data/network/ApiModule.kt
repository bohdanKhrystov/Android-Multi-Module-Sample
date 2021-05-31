package com.bohdanhub.data.network

import com.bohdanhub.data.network.api.AuthApi
import com.bohdanhub.data.network.api.UserApi
import com.bohdanhub.share.di.scopes.PerApplication
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object ApiModule {

    @JvmStatic
    @Provides
    @PerApplication
    fun provideAuthApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)

    @JvmStatic
    @Provides
    @PerApplication
    fun provideNetworkApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)
}