package pl.adamchodera.githubconsumer.ui.repositorylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import pl.adamchodera.githubconsumer.data.DefaultGitHubRepository
import pl.adamchodera.githubconsumer.data.model.Repository
import pl.adamchodera.githubconsumer.data.model.api.RepositoryResponse
import pl.adamchodera.githubconsumer.data.source.remote.GitHubApiConstants
import javax.inject.Inject

/**
 * Created by Adam Chodera on 20/06/2021.
 */
@HiltViewModel
class RepositoryListViewModel @Inject constructor(
    private val defaultGitHubRepository: DefaultGitHubRepository,
    ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    val publicRepositories: LiveData<List<Repository?>?> = liveData(ioDispatcher) {
        emit(defaultGitHubRepository.getPublicReposForUser(GitHubApiConstants.GITHUB_USERNAME))
    }
}