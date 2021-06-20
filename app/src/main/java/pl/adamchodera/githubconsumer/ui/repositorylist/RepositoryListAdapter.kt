package pl.adamchodera.githubconsumer.ui.repositorylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pl.adamchodera.githubconsumer.data.model.Repository
import pl.adamchodera.githubconsumer.databinding.ItemRepositoryBinding

/**
 * Created by Adam Chodera on 20/06/2021.
 */
class RepositoryListAdapter : ListAdapter<Repository, RepositoryListAdapter.RepositoryViewHolder>(Companion) {

    class RepositoryViewHolder(val binding: ItemRepositoryBinding) : RecyclerView.ViewHolder(binding.root)

    companion object: DiffUtil.ItemCallback<Repository>() {
        override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRepositoryBinding.inflate(layoutInflater)

        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repo = getItem(position)
        holder.binding.repo = repo
        holder.binding.executePendingBindings()
    }
}