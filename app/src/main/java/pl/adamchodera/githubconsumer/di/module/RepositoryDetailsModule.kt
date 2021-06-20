package pl.adamchodera.githubconsumer.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import pl.adamchodera.githubconsumer.di.ViewModelBuilder
import pl.adamchodera.githubconsumer.di.ViewModelKey
import pl.adamchodera.githubconsumer.ui.repositorydetails.RepositoryDetailsFragment
import pl.adamchodera.githubconsumer.ui.repositorydetails.RepositoryDetailsViewModel

/**
 * Created by Adam Chodera on 20/06/2021.
 */
@Module
abstract class RepositoryDetailsModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class
        ]
    )
    internal abstract fun mainFragment(): RepositoryDetailsFragment

    @Binds
    @IntoMap
    @ViewModelKey(RepositoryDetailsViewModel::class)
    abstract fun bindViewModel(viewModel: RepositoryDetailsViewModel): ViewModel
}
