package pl.adamchodera.githubconsumer.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineDispatcher
import pl.adamchodera.githubconsumer.data.DefaultGitHubRepository
import pl.adamchodera.githubconsumer.data.model.RepoResponse
import pl.adamchodera.githubconsumer.data.source.remote.GitHubApiConstants
import javax.inject.Inject

/**
 * Created by Adam Chodera on 20/06/2021.
 */
class RepositoriesListViewModel @Inject constructor(
    private val defaultGitHubRepository: DefaultGitHubRepository,
    ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    val publicRepositories: LiveData<List<RepoResponse?>?> = liveData(ioDispatcher) {
        emit(defaultGitHubRepository.getPublicReposForUser(GitHubApiConstants.GITHUB_USERNAME))
    }
}