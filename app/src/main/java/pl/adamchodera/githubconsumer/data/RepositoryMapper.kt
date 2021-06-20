package pl.adamchodera.githubconsumer.data

import pl.adamchodera.githubconsumer.data.model.Repository
import pl.adamchodera.githubconsumer.data.model.api.RepositoryResponse
import javax.inject.Inject

/**
 * Created by Adam Chodera on 20/06/2021.
 */
class RepositoryMapper @Inject constructor() {

    fun transform(response: RepositoryResponse?): Repository =
        Repository(response?.id, response?.fullName, response?.description)

}