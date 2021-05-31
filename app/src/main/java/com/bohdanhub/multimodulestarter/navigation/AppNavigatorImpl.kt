package com.bohdanhub.multimodulestarter.navigation

import android.content.Context
import com.bohdanhub.auth.ui.AuthActivity
import com.bohdanhub.repositories.ui.all.AllRepositoriesActivity
import com.bohdanhub.share.navigation.AppNavigator
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor() : AppNavigator {

    override fun navigateToAllRepositories(context: Context) {
        context.startActivity(AllRepositoriesActivity.getIntent(context))
    }

    override fun navigateToAuth(context: Context) {
        context.startActivity(AuthActivity.getIntent(context))
    }
}