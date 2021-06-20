package pl.adamchodera.githubconsumer.data

import pl.adamchodera.githubconsumer.data.source.remote.GitHubApiService
import javax.inject.Inject

/**
 * Created by Adam Chodera on 20/06/2021.
 */
class DefaultGitHubRepository @Inject constructor(
    private val gitHubApiService: GitHubApiService,
    private val repositoryMapper: RepositoryMapper
    private val commitMapper: CommitMapper
) {

    suspend fun getPublicReposForUser(userName: String) =
        gitHubApiService.listRepos(userName)?.map { repositoryMapper.transform(it) }

    suspend fun getCommitsForUserRepository(userName: String, repositoryName: String) =
        gitHubApiService.listCommits(userName, repositoryName)?.map { commitMapper.transform(it) }
}