package com.bohdanhub.auth.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bohdanhub.domain.entity.auth.AccessToken
import com.bohdanhub.domain.entity.auth.TokenRequest
import com.bohdanhub.domain.usecase.BaseUseCase
import com.bohdanhub.share_ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val useCase: BaseUseCase<TokenRequest, AccessToken>
) : BaseViewModel() {

    fun getAccessToken(authCode: String): LiveData<AccessToken> {
        val data = MutableLiveData<AccessToken>()
        uiScope.launch(coroutineExceptionHandler) {
            val accessToken = useCase.execute(TokenRequest(authCode))
            data.value = accessToken
        }
        return data
    }
}