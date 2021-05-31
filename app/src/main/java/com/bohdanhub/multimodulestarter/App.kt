package com.bohdanhub.multimodulestarter

import com.bohdanhub.data.network.interceptor.UnauthorizedInterceptor
import com.bohdanhub.share.navigation.AppNavigator
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class App : DaggerApplication() {

    @Inject
    lateinit var appNavigator: AppNavigator

    override fun onCreate() {
        super.onCreate()

        UnauthorizedInterceptor.UnauthorizedObserver.subscribe(object :
            UnauthorizedInterceptor.UnauthorizedObserver.UnauthorizedListener {
            override fun onUnauthorized() {
                appNavigator.navigateToAuth(this@App, isNewTask = true)
            }
        })
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this)
}