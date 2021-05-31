package com.bohdanhub.data.storage.auth

import android.content.Context
import com.bohdanhub.domain.entity.auth.AccessToken
import com.bohdanhub.domain.storage.TokenStorage
import com.bohdanhub.share.di.qualifiers.AppContext
import com.google.gson.Gson
import javax.inject.Inject

class PreferenceTokenStorage @Inject constructor(
    @AppContext context: Context,
    private val gson: Gson
) : TokenStorage {

    private val preferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)

    private companion object {
        const val PREF_FILE_NAME = "access_token.preferences"

        const val KEY_TOKEN = "token"
    }

    override fun saveToken(accessToken: AccessToken) {
        preferences.edit().putString(KEY_TOKEN, accessToken.token).apply()
    }

    override fun getToken(): AccessToken {
        return AccessToken(preferences.getString(KEY_TOKEN, "") ?: "")
    }
}