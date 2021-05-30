package com.bohdanhub.auth.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bohdanhub.auth.R
import com.bohdanhub.auth.databinding.ActivityAuthBinding
import com.bohdanhub.data.network.api.AuthApi
import com.bohdanhub.share_ui.base.BaseActivity
import com.bohdanhub.share_ui.system.IntentFactory

class AuthActivity : BaseActivity() {

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

    private fun getAccessToken(code: String?) {
        if (code != null) {
            //TODO: get access token
        }
    }

    private fun getAuthCode(intent: Intent?): String? {
        val uri = Uri.parse(intent?.toUri(0).toString())
        val code: String? = uri.getQueryParameter("code")
        return code
    }
}