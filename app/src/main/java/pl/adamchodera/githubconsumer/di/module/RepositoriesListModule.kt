package pl.adamchodera.githubconsumer.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import pl.adamchodera.githubconsumer.di.ViewModelBuilder
import pl.adamchodera.githubconsumer.di.ViewModelKey
import pl.adamchodera.githubconsumer.ui.main.RepositoriesListFragment
import pl.adamchodera.githubconsumer.ui.main.RepositoriesListViewModel

/**
 * Created by Adam Chodera on 20/06/2021.
 */
@Module
abstract class RepositoriesListModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class
        ]
    )
    internal abstract fun mainFragment(): RepositoriesListFragment

    @Binds
    @IntoMap
    @ViewModelKey(RepositoriesListViewModel::class)
    abstract fun bindViewModel(viewModel: RepositoriesListViewModel): ViewModel
}
