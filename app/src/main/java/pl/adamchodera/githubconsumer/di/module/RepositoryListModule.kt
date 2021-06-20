package pl.adamchodera.githubconsumer.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import pl.adamchodera.githubconsumer.di.ViewModelBuilder
import pl.adamchodera.githubconsumer.di.ViewModelKey
import pl.adamchodera.githubconsumer.ui.repositorylist.RepositoryListFragment
import pl.adamchodera.githubconsumer.ui.repositorylist.RepositoryListViewModel

/**
 * Created by Adam Chodera on 20/06/2021.
 */
@Module
abstract class RepositoryListModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class
        ]
    )
    internal abstract fun mainFragment(): RepositoryListFragment

    @Binds
    @IntoMap
    @ViewModelKey(RepositoryListViewModel::class)
    abstract fun bindViewModel(viewModel: RepositoryListViewModel): ViewModel
}
