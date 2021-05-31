package com.bohdanhub.data.model.repository

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String
)