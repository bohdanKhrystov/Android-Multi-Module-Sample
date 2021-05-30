package com.bohdanhub.domain.usecase

interface BaseUseCase<REQUEST, RESULT> {
    suspend fun execute(request: REQUEST): RESULT
}