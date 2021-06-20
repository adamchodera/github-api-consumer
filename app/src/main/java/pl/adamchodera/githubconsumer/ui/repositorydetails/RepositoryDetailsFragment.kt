package pl.adamchodera.githubconsumer.ui.repositorydetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import pl.adamchodera.githubconsumer.databinding.RepositoryDetailsFragmentBinding
import pl.adamchodera.githubconsumer.ui.BaseFragment

/**
 * Created by Adam Chodera on 20/06/2021.
 */
class RepositoryDetailsFragment : BaseFragment() {

    private val repositoryDetailsViewModel by viewModels<RepositoryDetailsViewModel> { viewModelFactory }
    val args: RepositoryDetailsFragmentArgs by navArgs()

    private val commitListAdapter = CommitListAdapter()

    private lateinit var viewDataBinding: RepositoryDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = RepositoryDetailsFragmentBinding.inflate(inflater, container, false)
            .apply {
                viewModel = repositoryDetailsViewModel
                lifecycleOwner = viewLifecycleOwner
                adapter = commitListAdapter
            }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        repositoryDetailsViewModel.commits(args.repository).observe(viewLifecycleOwner, Observer {
            it.let(commitListAdapter::submitList)
        })
    }
}