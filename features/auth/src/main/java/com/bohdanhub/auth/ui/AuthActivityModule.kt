package com.bohdanhub.auth.ui

import com.bohdanhub.share_ui.base.BaseActivity
import com.bohdanhub.share_ui.di.base.BaseActivityModule
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        BaseActivityModule::class
    ]
)
interface AuthActivityModule {

    @Binds
    abstract fun bindBaseActivity(activity: AuthActivity): BaseActivity
}