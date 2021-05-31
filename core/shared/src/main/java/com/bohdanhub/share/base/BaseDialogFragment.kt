package com.bohdanhub.share.base

import android.content.Context
import androidx.fragment.app.DialogFragment
import com.bohdanhub.share.di.qualifiers.ActivityContext
import com.tallium.eubank.core.shared.base.IUi
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseDialogFragment: DialogFragment(), HasAndroidInjector {

    @Inject
    protected lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    protected lateinit var iUi: IUi

    @Inject
    @field: ActivityContext
    protected lateinit var activityContext: Context


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

}