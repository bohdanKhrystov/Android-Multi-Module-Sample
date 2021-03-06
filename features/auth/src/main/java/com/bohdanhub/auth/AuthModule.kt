package com.bohdanhub.auth

import com.bohdanhub.auth.ui.AuthActivity
import com.bohdanhub.auth.ui.AuthActivityModule
import com.bohdanhub.share.di.scopes.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AuthModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [AuthActivityModule::class])
    fun bindAuthActivity(): AuthActivity
}