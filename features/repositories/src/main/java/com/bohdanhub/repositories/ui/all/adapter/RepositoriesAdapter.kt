package com.bohdanhub.repositories.ui.all.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bohdanhub.domain.entity.repository.Repository
import com.bohdanhub.repositories.R
import com.bohdanhub.repositories.databinding.RepositoryItemBinding

class RepositoriesAdapter(private val items: List<Repository>) :
    RecyclerView.Adapter<RepositoriesAdapter.RepositoryVh>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryVh {
        val binding = DataBindingUtil.inflate<RepositoryItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.repository_item,
            parent,
            false
        )
        return RepositoryVh(binding)
    }

    override fun onBindViewHolder(holder: RepositoryVh, position: Int) {
        holder.bind(items[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class RepositoryVh(private val binding: RepositoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repository: Repository) {
            binding.title.text = repository.name
            binding.description.text = repository.description
        }
    }
}