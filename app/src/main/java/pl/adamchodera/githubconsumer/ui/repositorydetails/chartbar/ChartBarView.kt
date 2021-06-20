package pl.adamchodera.githubconsumer.ui.repositorydetails.chartbar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import pl.adamchodera.githubconsumer.R
import pl.adamchodera.githubconsumer.databinding.ViewChartBinding

/**
 * Created by Adam Chodera on 20/06/2021.
 */
class ChartBarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var viewBinding: ViewChartBinding
    private val viewModel = ChartBarViewModel()

    init {
        val inflater = LayoutInflater.from(context)
        viewBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.view_chart,
            this,
            true
        )
    }

    fun onLifecycleOwnerAttached(lifecycleOwner: LifecycleOwner) {
        viewBinding.lifecycleOwner = lifecycleOwner
        observe(lifecycleOwner)
    }

    private fun observe(lifecycleOwner: LifecycleOwner) {
        viewModel.numberOfCommitsInCurrentMonth.observe(lifecycleOwner, Observer { number ->
            if (number == null) return@Observer
            viewBinding.numberOfCommit.text = context.getString(R.string.chart_bar_commits, number)
        })
        viewModel.monthNameLiveData.observe(lifecycleOwner, { name ->
            viewBinding.monthName.text = name
        })
        viewModel.heightForCharBar.observe(lifecycleOwner, { heightInDp ->
            viewBinding.chartBarView.layoutParams.apply {
                height = heightInDp
            }
        })
    }
}