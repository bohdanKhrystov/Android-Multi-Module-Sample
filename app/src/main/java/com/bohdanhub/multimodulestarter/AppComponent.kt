package com.bohdanhub.multimodulestarter

import com.bohdanhub.auth.AuthModule
import com.bohdanhub.data.network.NetworkModule
import com.bohdanhub.data.repository.RepositoriesModule
import com.bohdanhub.data.storage.StorageModule
import com.bohdanhub.repositories.ui.RepositoriesFeatureModule
import com.bohdanhub.share.di.scopes.PerApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [
        AndroidSupportInjectionModule::class,

        AppModule::class,
        AuthModule::class,
        RepositoriesFeatureModule::class,

        NetworkModule::class,
        StorageModule::class,
        RepositoriesModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<App>

}