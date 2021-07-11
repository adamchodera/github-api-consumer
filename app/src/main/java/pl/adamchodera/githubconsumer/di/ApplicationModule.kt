package pl.adamchodera.githubconsumer.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import pl.adamchodera.githubconsumer.data.source.remote.GitHubApiConstants
import pl.adamchodera.githubconsumer.data.source.remote.GitHubApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Adam Chodera on 20/06/2021.
 */
@InstallIn(SingletonComponent::class)
@Module
open class ApplicationModule {

    @Singleton
    @Provides
    fun provideGitHubApiService(): GitHubApiService {
        return Retrofit.Builder()
            .baseUrl(GitHubApiConstants.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

}
