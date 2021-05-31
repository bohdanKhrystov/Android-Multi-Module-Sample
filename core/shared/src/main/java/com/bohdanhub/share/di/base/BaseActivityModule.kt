package com.bohdanhub.share.di.base

import android.annotation.SuppressLint
import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.bohdanhub.share.base.BaseActivity
import com.bohdanhub.share.di.ViewModelProviderFactory
import com.bohdanhub.share.di.qualifiers.ActivityContext
import com.bohdanhub.share.di.qualifiers.ActivityFragmentManager
import com.bohdanhub.share.di.scopes.PerActivity
import com.tallium.eubank.core.shared.base.IUi
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class BaseActivityModule {

    @ActivityContext
    @Binds
    abstract fun bindActivityContext(activity: BaseActivity): Context

    @Binds
    abstract fun bindIUi(activity: BaseActivity): IUi

    @Binds
    @PerActivity
    abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory

    @SuppressLint("ModuleCompanionObjects")
    @Module
    companion object {
        @SuppressLint("JvmStaticProvidesInObjectDetector")
        @JvmStatic
        @Provides
        @ActivityFragmentManager
        fun provideFragmentManager(activity: BaseActivity): FragmentManager {
            return activity.supportFragmentManager
        }
    }
}