package com.tallium.eubank.core.shared.base

import androidx.annotation.StringRes

interface IUi {

    /**
     * Interface for showing errors
     */

    fun showError(message: String?)

    fun showError(throwable: Throwable?)

    fun showError(@StringRes stringRes: Int)


    /**
     * Interface for showing progress
     */

    fun showProgress(visible: Boolean)


    /**
     * Interface for showing messages
     */

    enum class MessageType {
        ERROR, SUCCESS, WARN, INFO
    }

    fun showMessage(message: String?, type: MessageType)

    fun showMessage(@StringRes res: Int, type: MessageType)
}