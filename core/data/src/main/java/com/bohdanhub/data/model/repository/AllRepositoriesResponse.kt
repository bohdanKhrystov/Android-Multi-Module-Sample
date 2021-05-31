package com.bohdanhub.data.model.repository

import com.google.gson.annotations.SerializedName

data class AllRepositoriesResponse(
    @SerializedName("r") val repositories: String
)