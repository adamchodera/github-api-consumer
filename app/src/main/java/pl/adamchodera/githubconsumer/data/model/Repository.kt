package pl.adamchodera.githubconsumer.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Adam Chodera on 20/06/2021.
 */
@Parcelize
data class Repository(
    val id: String?,
    val name: String?,
    val description: String?
) : Parcelable
