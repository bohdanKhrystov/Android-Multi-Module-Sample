package com.bohdanhub.share.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class BaseViewModel: ViewModel() {

    private val job = SupervisorJob()

    protected val uiScope = CoroutineScope(Dispatchers.Main + job )
    protected val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, exception ->
        println("Handle $exception in CoroutineExceptionHandler")
        exception.printStackTrace()
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}