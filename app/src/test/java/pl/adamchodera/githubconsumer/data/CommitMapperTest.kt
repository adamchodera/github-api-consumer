package pl.adamchodera.githubconsumer.data

import org.junit.Assert
import org.junit.Before
import org.junit.Test

import pl.adamchodera.githubconsumer.data.model.Commit
import pl.adamchodera.githubconsumer.data.model.api.CommitResponse

/**
 * Created by Adam Chodera on 26/06/2021.
 */
class CommitMapperTest {

    private var commitMapper: CommitMapper = CommitMapper()
    private lateinit var commit: Commit

    @Before
    fun setUp() {
        commit = commitMapper.transform(TEST_COMMIT_RESPONSE)
    }

    @Test
    fun verify_message_is_mapped_properly() {
        Assert.assertEquals(commit.message, TEST_COMMIT_RESPONSE.details?.message)
    }

    @Test
    fun verify_sha_is_mapped_properly() {
        Assert.assertEquals(commit.sha, TEST_COMMIT_RESPONSE.sha)
    }

    companion object {
        val TEST_COMMIT_RESPONSE = CommitResponse(
            "sha",
            CommitResponse.CommitDetailsResponse("message")
        )
    }
}