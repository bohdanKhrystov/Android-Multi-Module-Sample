package com.bohdanhub.share_ui.system

import android.content.Intent
import android.net.Uri

object IntentFactory {

    fun buildBrowserIntent(url: String): Intent {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        return intent
    }
}