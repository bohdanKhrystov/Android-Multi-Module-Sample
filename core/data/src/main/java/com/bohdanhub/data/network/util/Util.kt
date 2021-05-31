package com.bohdanhub.data.network.util

import retrofit2.Response

fun <T> handleApiRequest(response: Response<T>): T {
    if (response.isSuccessful) {
        val body = response.body()
        if (body != null) {
            return body
        }
    }
    throw RuntimeException("response not successful $response")
}