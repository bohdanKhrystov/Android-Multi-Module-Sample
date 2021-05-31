package com.bohdanhub.data.network

import com.bohdanhub.data.BuildConfig
import com.bohdanhub.data.network.interceptor.HeadersInterceptor
import com.bohdanhub.data.network.interceptor.UnauthorizedInterceptor
import com.bohdanhub.domain.storage.TokenStorage
import com.bohdanhub.share.di.scopes.PerApplication
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

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
    fun provideHeadersInterceptor(storage: TokenStorage): HeadersInterceptor {
        return HeadersInterceptor(storage)
    }


    @JvmStatic
    @Provides
    @PerApplication
    fun provideHttpClient(
        authInterceptor: HeadersInterceptor
    ): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()

        httpBuilder.addInterceptor(authInterceptor)
        httpBuilder.addInterceptor(UnauthorizedInterceptor())

        httpBuilder.callTimeout(60, TimeUnit.SECONDS)
        httpBuilder.connectTimeout(60, TimeUnit.SECONDS)
        httpBuilder.readTimeout(60, TimeUnit.SECONDS)
        httpBuilder.writeTimeout(60, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            httpBuilder.addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
        }

        return httpBuilder.build()
    }


    @JvmStatic
    @Provides
    @PerApplication
    @Named("default")
    fun provideRetrofit(
        gson: Gson,
        httpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.GITHUB_COM)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient)
            .build()
    }

    @JvmStatic
    @Provides
    @PerApplication
    @Named("api")
    fun provideApiRetrofit(
        gson: Gson,
        httpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_GITHUB_COM)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient)
            .build()
    }
}