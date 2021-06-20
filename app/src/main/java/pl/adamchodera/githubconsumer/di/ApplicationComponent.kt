package pl.adamchodera.githubconsumer.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import pl.adamchodera.githubconsumer.GitHubApp
import pl.adamchodera.githubconsumer.di.module.ApplicationModule
import pl.adamchodera.githubconsumer.di.module.MainActivityModule
import pl.adamchodera.githubconsumer.di.module.RepositoryListModule

import javax.inject.Singleton

/**
 * Created by Adam Chodera on 20/06/2021.
 */
@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        MainActivityModule::class,
        RepositoryListModule::class,
    ]
)
interface ApplicationComponent : AndroidInjector<GitHubApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}
