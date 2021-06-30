package pl.adamchodera.githubconsumer.data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import pl.adamchodera.githubconsumer.data.model.Repository

import pl.adamchodera.githubconsumer.data.source.remote.GitHubApiService

/**
 * Created by Adam Chodera on 26/06/2021.
 */
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DefaultGitHubRepositoryTest {

    @Mock
    private lateinit var gitHubApiService: GitHubApiService

    @Mock
    private lateinit var repositoryMapper: RepositoryMapper

    @Mock
    private lateinit var commitMapper: CommitMapper

    private lateinit var repository: DefaultGitHubRepository

    @Before
    fun setUp() {
        repository = DefaultGitHubRepository(gitHubApiService, repositoryMapper, commitMapper)
    }

    @Test
    fun `verify github service was called to fetch list of repos`() = runBlockingTest {
        repository.getPublicReposForUser(TEST_USERNAME)

        verify(gitHubApiService).listRepos(eq(TEST_USERNAME), any())
    }

    @Test
    fun `verify github service was called to fetch list of commits`() = runBlockingTest {
        repository.getCommitsForUserRepository(TEST_USERNAME, REPOSITORY_NAME)

        verify(gitHubApiService).listCommits(eq(TEST_USERNAME), eq(REPOSITORY_NAME))
    }

    companion object {
        const val TEST_USERNAME = "test_username"
        const val REPOSITORY_NAME = "repository_name"
        val REPOSITORY = Repository("id", REPOSITORY_NAME, "description")
    }
}