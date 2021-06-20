package pl.adamchodera.githubconsumer.ui.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Adam Chodera on 20/06/2021.
 */
@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}