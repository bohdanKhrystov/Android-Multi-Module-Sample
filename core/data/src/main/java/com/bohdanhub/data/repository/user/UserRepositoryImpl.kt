package com.bohdanhub.data.repository.user

import com.bohdanhub.data.model.repository.RepositoryResponse
import com.bohdanhub.data.model.user.UserResponse
import com.bohdanhub.data.network.api.UserApi
import com.bohdanhub.data.network.util.handleApiRequest
import com.bohdanhub.domain.entity.repository.Repository
import com.bohdanhub.domain.entity.user.User
import com.bohdanhub.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi
) : UserRepository {

    override suspend fun getUser(): User {
        val response: UserResponse = handleApiRequest(api.getUser())
        return User(response.login)
    }

    override suspend fun getRepositories(userName: String): List<Repository> {
        val response: List<RepositoryResponse> =
            handleApiRequest(api.getAllRepositories(userName))
        return response.map { webRepo ->
            Repository(
                name = webRepo.name,
                description = webRepo.description
            )
        }
    }
}