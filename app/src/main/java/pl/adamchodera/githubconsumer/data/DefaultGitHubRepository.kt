package pl.adamchodera.githubconsumer.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import pl.adamchodera.githubconsumer.data.model.RepoResponse
import pl.adamchodera.githubconsumer.data.source.remote.GitHubApiService
import javax.inject.Inject

/**
 * Created by Adam Chodera on 20/06/2021.
 */
class DefaultGitHubRepository @Inject constructor(
    private val gitHubApiService: GitHubApiService,
    private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun getPublicReposForUser(userName: String) = gitHubApiService.listRepos(userName)
}