package com.bohdanhub.multimodulestarter.navigation

import android.content.Context
import android.content.Intent
import com.bohdanhub.auth.ui.AuthActivity
import com.bohdanhub.repositories.ui.all.AllRepositoriesActivity
import com.bohdanhub.share.navigation.AppNavigator
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor() : AppNavigator {

    override fun navigateToAllRepositories(context: Context) {
        context.startActivity(AllRepositoriesActivity.getIntent(context).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        })
    }

    override fun navigateToAuth(context: Context) {
        context.startActivity(AuthActivity.getIntent(context).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        })
    }
}