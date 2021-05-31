package com.bohdanhub.domain.repository

import com.bohdanhub.domain.entity.repository.Repository
import com.bohdanhub.domain.entity.user.User

interface UserRepository {

    suspend fun getUser(): User

    suspend fun getRepositories(userName: String): List<Repository>
}