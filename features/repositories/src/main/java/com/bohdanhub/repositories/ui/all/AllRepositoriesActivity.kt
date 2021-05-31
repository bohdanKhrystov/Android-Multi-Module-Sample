package com.bohdanhub.repositories.ui.all

import android.os.Bundle
import com.bohdanhub.repositories.R
import com.bohdanhub.share.base.BaseViewModelActivity

class AllRepositoriesActivity : BaseViewModelActivity<AllRepositoriesViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_repositories)
    }

    override fun getViewModelClass(): Class<AllRepositoriesViewModel> =
        AllRepositoriesViewModel::class.java
}