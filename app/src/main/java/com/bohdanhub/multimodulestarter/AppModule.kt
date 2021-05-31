package com.bohdanhub.multimodulestarter

import android.app.Application
import android.content.Context
import com.bohdanhub.multimodulestarter.navigation.AppNavigatorImpl
import com.bohdanhub.share.di.qualifiers.AppContext
import com.bohdanhub.share.di.scopes.PerApplication
import com.bohdanhub.share.navigation.AppNavigator
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    @PerApplication
    abstract fun provideApp(app: App): Application

    @Binds
    @PerApplication
    @AppContext
    abstract fun bindAppContext(app: App): Context

    @Binds
    @PerApplication
    abstract fun bindAppNavigator(nav: AppNavigatorImpl): AppNavigator
}