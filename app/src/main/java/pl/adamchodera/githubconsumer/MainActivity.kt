package pl.adamchodera.githubconsumer

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import pl.adamchodera.githubconsumer.ui.main.RepositoriesListFragment

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RepositoriesListFragment.newInstance())
                .commitNow()
        }
    }
}