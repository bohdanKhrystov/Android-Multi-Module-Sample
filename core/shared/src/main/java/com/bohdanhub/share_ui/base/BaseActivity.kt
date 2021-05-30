package com.bohdanhub.share_ui.base

import android.widget.Toast
import androidx.annotation.StringRes
import com.tallium.eubank.core.shared.base.IUi
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity(), IUi {

    /** Implementation of IUi interface */

    override fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showError(throwable: Throwable?) {
        showError(throwable?.message)
    }

    override fun showError(@StringRes stringRes: Int) {
        showError(getString(stringRes))
    }

    override fun showMessage(message: String?, type: IUi.MessageType) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showMessage(@StringRes res: Int, type: IUi.MessageType) {
        showMessage(getString(res), type)
    }

    override fun showProgress(visible: Boolean) {}
}