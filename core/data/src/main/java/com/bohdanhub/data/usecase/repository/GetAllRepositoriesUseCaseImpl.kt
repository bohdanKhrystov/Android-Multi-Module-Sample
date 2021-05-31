package com.bohdanhub.data.usecase.repository

import com.bohdanhub.data.usecase.user.GetUserUseCase
import com.bohdanhub.domain.entity.repository.AllRepositoriesRequest
import com.bohdanhub.domain.entity.repository.Repository
import com.bohdanhub.domain.entity.user.UserRequest
import com.bohdanhub.domain.repository.UserRepository
import com.bohdanhub.domain.usecase.GetAllRepositoriesUseCase
import javax.inject.Inject

class GetAllRepositoriesUseCaseImpl @Inject constructor(
    private val repository: UserRepository,
    private val getUserUseCase: GetUserUseCase
) : GetAllRepositoriesUseCase {

    override suspend fun execute(request: AllRepositoriesRequest): List<Repository> {
        val userName = getUserUseCase.execute(UserRequest()).id.toString()
        return repository.getRepositories(userName)
    }
}