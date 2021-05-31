package com.bohdanhub.share.navigation

import android.content.Context

interface AppNavigator {
    fun navigateToAllRepositories(context: Context)
    fun navigateToAuth(context: Context, isNewTask: Boolean = false)
}