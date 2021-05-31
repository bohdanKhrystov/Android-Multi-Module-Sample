package com.bohdanhub.auth.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bohdanhub.auth.R
import com.bohdanhub.auth.databinding.ActivityAuthBinding
import com.bohdanhub.data.network.api.AuthApi
import com.bohdanhub.share.base.BaseViewModelActivity
import com.bohdanhub.share.navigation.AppNavigator
import com.bohdanhub.share.system.IntentFactory
import javax.inject.Inject

class AuthActivity : BaseViewModelActivity<AuthViewModel>() {

    @Inject
    lateinit var appNavigator: AppNavigator

    lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)

        binding.loginButton.setOnClickListener {
            startActivity(IntentFactory.buildBrowserIntent(AuthApi.buildAuthUrl()))
        }

        getAccessToken(getAuthCode(intent))
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        getAccessToken(getAuthCode(intent))
    }

    override fun getViewModelClass(): Class<AuthViewModel> = AuthViewModel::class.java

    private fun getAccessToken(code: String?) {
        if (code != null) {
            viewModel.getAccessToken(code).observe(this, Observer {
                Log.d("TokenDebug", "Token = ${it.token}")
                appNavigator.navigateToAllRepositories(this@AuthActivity)
            })
        }
    }

    private fun getAuthCode(intent: Intent?): String? {
        val uri = Uri.parse(intent?.toUri(0).toString())
        val code: String? = uri.getQueryParameter("code")
        return code
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, AuthActivity::class.java)
        }
    }
}