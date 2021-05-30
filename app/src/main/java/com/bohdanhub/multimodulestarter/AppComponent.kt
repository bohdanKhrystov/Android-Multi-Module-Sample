package com.bohdanhub.multimodulestarter

import com.bohdanhub.auth.AuthModule
import com.bohdanhub.data.network.NetworkModule
import com.bohdanhub.data.repository.RepositoriesModule
import com.bohdanhub.share_ui.di.scopes.PerApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [
        AndroidSupportInjectionModule::class,

        AppModule::class,
        AuthModule::class,

        NetworkModule::class,
        RepositoriesModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<App>

}