package com.bohdanhub.data.usecase.user

import com.bohdanhub.domain.entity.user.User
import com.bohdanhub.domain.entity.user.UserRequest
import com.bohdanhub.domain.repository.UserRepository
import com.bohdanhub.domain.usecase.BaseUseCase
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) : BaseUseCase<UserRequest, User> {

    override suspend fun execute(request: UserRequest): User {
        return repository.getUser()
    }
}