package pl.adamchodera.githubconsumer.ui.repositorylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import pl.adamchodera.githubconsumer.data.model.Repository
import pl.adamchodera.githubconsumer.databinding.RepositoryListFragmentBinding
import pl.adamchodera.githubconsumer.ui.BaseFragment

/**
 * Created by Adam Chodera on 20/06/2021.
 */
class RepositoryListFragment : BaseFragment(), RepositoryListAdapter.RepositoryClickedListener {

    companion object {
        fun newInstance() = RepositoryListFragment()
    }

    private val mainViewModel by viewModels<RepositoryListViewModel> { viewModelFactory }
    private val repositoryListAdapter = RepositoryListAdapter(this)

    private lateinit var viewDataBinding: RepositoryListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = RepositoryListFragmentBinding.inflate(inflater, container, false)
            .apply {
                viewModel = mainViewModel
                lifecycleOwner = viewLifecycleOwner
                adapter = repositoryListAdapter
            }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.publicRepositories.observe(viewLifecycleOwner, Observer {
            it.let(repositoryListAdapter::submitList)
        })
    }

    override fun onRepositoryClicked(repository: Repository) {
        findNavController().navigate(
            RepositoryListFragmentDirections.actionRepositoryListFragmentToRepositoryDetailsFragment(repository)
        )
    }
}