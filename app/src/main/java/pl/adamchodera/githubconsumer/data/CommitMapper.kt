package pl.adamchodera.githubconsumer.data

import pl.adamchodera.githubconsumer.data.model.Commit
import pl.adamchodera.githubconsumer.data.model.api.CommitResponse
import javax.inject.Inject

/**
 * Created by Adam Chodera on 20/06/2021.
 */
class CommitMapper @Inject constructor() {

    fun transform(response: CommitResponse?): Commit =
        Commit(response?.sha, response?.details?.message)

}