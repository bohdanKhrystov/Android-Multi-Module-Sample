package com.bohdanhub.data.model.user

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("login") val login: String
)