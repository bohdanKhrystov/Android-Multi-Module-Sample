package com.bohdanhub.multimodulestarter

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication()  {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this)
}