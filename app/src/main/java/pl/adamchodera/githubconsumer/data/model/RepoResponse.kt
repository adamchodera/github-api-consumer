package pl.adamchodera.githubconsumer.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Adam Chodera on 20/06/2021.
 */
data class RepoResponse(
    @SerializedName("full_name") val fullName: String?,
    @SerializedName("description") val description: String?
)