package com.bohdanhub.repositories.ui.all

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bohdanhub.data.usecase.user.GetUserUseCase
import com.bohdanhub.domain.entity.repository.AllRepositoriesRequest
import com.bohdanhub.domain.entity.repository.Repository
import com.bohdanhub.domain.entity.user.User
import com.bohdanhub.domain.entity.user.UserRequest
import com.bohdanhub.domain.usecase.GetAllRepositoriesUseCase
import com.bohdanhub.share.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class AllRepositoriesViewModel @Inject constructor(
    private val getAllRepositoriesUseCase: GetAllRepositoriesUseCase,
    private val getUserUseCase: GetUserUseCase
) : BaseViewModel() {

    private val repositories = MutableLiveData<List<Repository>>()
    private val user = MutableLiveData<User>()

    fun getRepositories(): LiveData<List<Repository>> {
        uiScope.launch(coroutineExceptionHandler) {
            val repositories = getAllRepositoriesUseCase.execute(AllRepositoriesRequest())
            this@AllRepositoriesViewModel.repositories.value = repositories
        }
        return repositories
    }

    fun getUser(): LiveData<User> {
        uiScope.launch(coroutineExceptionHandler) {
            val user = getUserUseCase.execute(UserRequest())
            this@AllRepositoriesViewModel.user.value = user
        }
        return user
    }
}