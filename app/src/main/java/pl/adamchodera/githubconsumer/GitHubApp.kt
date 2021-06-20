package pl.adamchodera.githubconsumer

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import pl.adamchodera.githubconsumer.di.DaggerApplicationComponent

class GitHubApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(applicationContext)
    }
}
