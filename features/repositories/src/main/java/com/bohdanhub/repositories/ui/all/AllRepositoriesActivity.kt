package com.bohdanhub.repositories.ui.all

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bohdanhub.repositories.R
import com.bohdanhub.repositories.databinding.ActivityAllRepositoriesBinding
import com.bohdanhub.repositories.ui.all.adapter.RepositoriesAdapter
import com.bohdanhub.share.base.BaseViewModelActivity


class AllRepositoriesActivity : BaseViewModelActivity<AllRepositoriesViewModel>() {

    lateinit var binding: ActivityAllRepositoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_repositories)

        val dividerItemDecoration = DividerItemDecoration(
            this,
            (binding.repositoriesRv.layoutManager as LinearLayoutManager).orientation
        )
        binding.repositoriesRv.addItemDecoration(dividerItemDecoration)
    }

    override fun onViewModelCreated() {
        super.onViewModelCreated()

        viewModel.getRepositories().observe(this, Observer { repositories ->
            binding.repositoriesRv.adapter = RepositoriesAdapter(repositories)
        })
        viewModel.getUser().observe(this, Observer { user ->
            title = getString(R.string.repositories__all_title, user.login)
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