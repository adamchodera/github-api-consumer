package pl.adamchodera.githubconsumer.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import pl.adamchodera.githubconsumer.R
import pl.adamchodera.githubconsumer.ui.BaseFragment

/**
 * Created by Adam Chodera on 20/06/2021.
 */
class RepositoriesListFragment : BaseFragment() {

    companion object {
        fun newInstance() = RepositoriesListFragment()
    }

    private val mainViewModel by viewModels<RepositoriesListViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.main_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.publicRepositories.observe(viewLifecycleOwner, Observer {
            it?.forEach { repo ->
                println(repo?.fullName)
            }
        })
    }
}