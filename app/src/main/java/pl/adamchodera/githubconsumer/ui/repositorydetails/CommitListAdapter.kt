package pl.adamchodera.githubconsumer.ui.repositorydetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pl.adamchodera.githubconsumer.data.model.Commit
import pl.adamchodera.githubconsumer.databinding.ItemCommitBinding

/**
 * Created by Adam Chodera on 20/06/2021.
 */
class CommitListAdapter : ListAdapter<Commit, CommitListAdapter.RepositoryViewHolder>(Companion) {

    class RepositoryViewHolder(val binding: ItemCommitBinding) : RecyclerView.ViewHolder(binding.root)

    companion object: DiffUtil.ItemCallback<Commit>() {
        override fun areItemsTheSame(oldItem: Commit, newItem: Commit): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: Commit, newItem: Commit): Boolean = oldItem.sha == newItem.sha
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCommitBinding.inflate(layoutInflater)

        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val commit = getItem(position)
        holder.binding.commit = commit
        holder.binding.executePendingBindings()
    }
}