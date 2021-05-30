package com.bohdanhub.share_ui.di.base

import android.annotation.SuppressLint
import android.content.Context
import androidx.fragment.app.FragmentManager
import com.bohdanhub.share_ui.base.BaseActivity
import com.tallium.eubank.core.shared.base.IUi
import com.bohdanhub.share_ui.di.qualifiers.ActivityContext
import com.bohdanhub.share_ui.di.qualifiers.ActivityFragmentManager
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