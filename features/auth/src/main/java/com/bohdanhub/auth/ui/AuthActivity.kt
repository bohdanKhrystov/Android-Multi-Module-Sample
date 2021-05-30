package com.bohdanhub.auth.ui

import android.os.Bundle
import com.bohdanhub.auth.R
import com.bohdanhub.share_ui.base.BaseActivity

class AuthActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }
}