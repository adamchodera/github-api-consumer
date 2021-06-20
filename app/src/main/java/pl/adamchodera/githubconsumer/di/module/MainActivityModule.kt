package pl.adamchodera.githubconsumer.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.adamchodera.githubconsumer.MainActivity

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity
}
