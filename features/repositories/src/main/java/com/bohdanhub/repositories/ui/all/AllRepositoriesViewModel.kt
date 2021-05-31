package com.bohdanhub.repositories.ui.all

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bohdanhub.domain.entity.repository.AllRepositoriesRequest
import com.bohdanhub.domain.entity.repository.Repository
import com.bohdanhub.domain.usecase.GetAllRepositoriesUseCase
import com.bohdanhub.share.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class AllRepositoriesViewModel @Inject constructor(
    private val getAllRepositoriesUseCase: GetAllRepositoriesUseCase
) : BaseViewModel() {

    fun subscribeRepositories(): LiveData<List<Repository>> = repositories

    private val repositories = MutableLiveData<List<Repository>>()

    fun getRepositories(): LiveData<List<Repository>> {
        uiScope.launch(coroutineExceptionHandler) {
            val repositories = getAllRepositoriesUseCase.execute(AllRepositoriesRequest())
            this@AllRepositoriesViewModel.repositories.value = repositories
        }
        return repositories
    }
}