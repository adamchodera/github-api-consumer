package pl.adamchodera.githubconsumer.ui.repositorydetails.chartbar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

/**
 * Created by Adam Chodera on 20/06/2021.
 */
data class ChartBarViewModel(
    val monthName: String = "June",
    val initCurrentNumber: Int = 10,
    val initMaxNumber: Int = 12,
    val initHeightInDp: Int = 120
) {
    val monthNameLiveData: LiveData<String> = MutableLiveData(monthName)

    private val _numberOfCommitsInCurrentMonth: MutableLiveData<Int?> =
        MutableLiveData(initCurrentNumber)
    val numberOfCommitsInCurrentMonth: LiveData<String> =
        Transformations.map(_numberOfCommitsInCurrentMonth) { it.toString() }

    val heightForCharBar: LiveData<Int> =
        Transformations.map(_numberOfCommitsInCurrentMonth) {
            val proportion = initCurrentNumber.toDouble() / initMaxNumber.toDouble()
            val heightInDp = proportion * initHeightInDp
            heightInDp.toInt()
        }
}
