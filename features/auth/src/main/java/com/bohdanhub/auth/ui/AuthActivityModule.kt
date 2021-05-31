package com.bohdanhub.auth.ui

import androidx.lifecycle.ViewModel
import com.bohdanhub.data.usecase.UseCaseModule
import com.bohdanhub.share.base.BaseActivity
import com.bohdanhub.share.di.base.BaseActivityModule
import com.bohdanhub.share.di.keys.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [
        BaseActivityModule::class,
        UseCaseModule::class
    ]
)
interface AuthActivityModule {

    @Binds
    abstract fun bindBaseActivity(activity: AuthActivity): BaseActivity

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    fun bindLoginViewModel(vm: AuthViewModel): ViewModel
}