package com.bohdanhub.share_ui.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class BaseSharedViewModelActivity<VM : BaseViewModel> : BaseActivity() {
    @Inject
    protected lateinit var factory: ViewModelProvider.Factory

    protected lateinit var viewModel: VM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, factory).get(getViewModelClass())
        onViewModelCreated()
    }


    abstract fun getViewModelClass(): Class<VM>

    open fun onViewModelCreated() {}

    open fun onViewModelDestroyed() {}


    override fun onDestroy() {
        super.onDestroy()
        onViewModelDestroyed()
    }

}