package com.bohdanhub.multimodulestarter.di

import com.bohdanhub.auth.AuthModule
import com.bohdanhub.multimodulestarter.App
import com.bohdanhub.share_ui.di.scopes.PerApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [
        AndroidSupportInjectionModule::class,

        AuthModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<App>

}