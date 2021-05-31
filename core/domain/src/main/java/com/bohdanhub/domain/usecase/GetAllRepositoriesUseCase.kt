package com.bohdanhub.domain.usecase

import com.bohdanhub.domain.entity.repository.AllRepositoriesRequest
import com.bohdanhub.domain.entity.repository.Repository

interface GetAllRepositoriesUseCase : BaseUseCase<AllRepositoriesRequest, List<Repository>>