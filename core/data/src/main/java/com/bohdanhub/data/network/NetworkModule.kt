package com.bohdanhub.data.network

import com.bohdanhub.data.BuildConfig
import com.bohdanhub.data.network.interceptor.UnauthorizedInterceptor
import com.bohdanhub.share.di.scopes.PerApplication
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

@Module(
    includes = [
        ApiModule::class
    ]
)
object NetworkModule {

    @JvmStatic
    @Provides
    @PerApplication
    fun provideNetworkDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @JvmStatic
    @Provides
    @PerApplication
    fun provideGson(): Gson {
        return Gson().newBuilder()
            .setLenient()
            .setPrettyPrinting()
            .create()
    }


    @JvmStatic
    @Provides
    @PerApplication
    fun provideHttpClient(
    ): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()

        httpBuilder.addInterceptor(UnauthorizedInterceptor())

        httpBuilder.callTimeout(60, TimeUnit.SECONDS)
        httpBuilder.connectTimeout(60, TimeUnit.SECONDS)
        httpBuilder.readTimeout(60, TimeUnit.SECONDS)
        httpBuilder.writeTimeout(60, TimeUnit.SECONDS)

        return httpBuilder.build()
    }


    @JvmStatic
    @Provides
    @PerApplication
    fun provideRetrofit(
        gson: Gson,
        httpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient)
            .build()
    }
}