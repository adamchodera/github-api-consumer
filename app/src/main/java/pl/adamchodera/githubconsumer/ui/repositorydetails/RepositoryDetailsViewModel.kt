package pl.adamchodera.githubconsumer.ui.repositorydetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineDispatcher
import pl.adamchodera.githubconsumer.data.DefaultGitHubRepository
import pl.adamchodera.githubconsumer.data.model.Commit
import pl.adamchodera.githubconsumer.data.model.Repository
import pl.adamchodera.githubconsumer.data.source.remote.GitHubApiConstants
import javax.inject.Inject

/**
 * Created by Adam Chodera on 20/06/2021.
 */
class RepositoryDetailsViewModel @Inject constructor(
    private val defaultGitHubRepository: DefaultGitHubRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    fun commits(repository: Repository): LiveData<List<Commit?>?> = liveData(ioDispatcher) {
        val repositoryName = repository.name ?: GitHubApiConstants.GITHUB_REPOSITORY_NAME
        emit(
            defaultGitHubRepository.getCommitsForUserRepository(
                GitHubApiConstants.GITHUB_USERNAME,
                repositoryName
            )
        )
    }
}