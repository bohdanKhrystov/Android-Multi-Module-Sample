package com.bohdanhub.repositories.ui.all

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
interface AllRepositoriesActivityModule {

    @Binds
    abstract fun bindBaseActivity(activity: AllRepositoriesActivity): BaseActivity

    @Binds
    @IntoMap
    @ViewModelKey(AllRepositoriesViewModel::class)
    fun bindLoginViewModel(vm: AllRepositoriesViewModel): ViewModel
}