package pl.adamchodera.githubconsumer.data.source.remote

import pl.adamchodera.githubconsumer.data.model.RepoResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Adam Chodera on 20/06/2021.
 */
interface GitHubApiService {

    @GET("users/{user}/repos")
    suspend fun listRepos(@Path("user") user: String?): List<RepoResponse?>?
}
