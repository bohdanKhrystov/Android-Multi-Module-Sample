package com.bohdanhub.repositories.ui.all

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.bohdanhub.repositories.R
import com.bohdanhub.share.base.BaseViewModelActivity
import com.tallium.eubank.core.shared.base.IUi

class AllRepositoriesActivity : BaseViewModelActivity<AllRepositoriesViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_repositories)
    }

    override fun onViewModelCreated() {
        super.onViewModelCreated()
        viewModel.getRepositories().observe(this, Observer { repositories ->
            showMessage(repositories.joinToString(), IUi.MessageType.INFO)
        })
    }

    override fun getViewModelClass(): Class<AllRepositoriesViewModel> =
        AllRepositoriesViewModel::class.java

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, AllRepositoriesActivity::class.java)
        }
    }
}