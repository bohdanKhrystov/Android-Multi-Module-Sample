package com.bohdanhub.data.model.repository

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("name") val name: String? = null,
    @SerializedName("description") val description: String? = null
)