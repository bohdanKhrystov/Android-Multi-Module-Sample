package com.bohdanhub.share_ui.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class BaseViewModelActivity<VM : ViewModel> : BaseActivity() {

    @Inject
    protected lateinit var factory: ViewModelProvider.Factory

    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(viewModelStore, factory).get(getViewModelClass())
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