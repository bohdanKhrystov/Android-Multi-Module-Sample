package com.bohdanhub.repositories.ui

import com.bohdanhub.repositories.ui.all.AllRepositoriesActivity
import com.bohdanhub.repositories.ui.all.AllRepositoriesActivityModule
import com.bohdanhub.share.di.scopes.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface RepositoriesFeatureModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [AllRepositoriesActivityModule::class])
    fun bindAllRepositoriesActivity(): AllRepositoriesActivity
}