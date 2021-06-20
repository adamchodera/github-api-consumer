package pl.adamchodera.githubconsumer.data.model.api

import com.google.gson.annotations.SerializedName

/**
 * Created by Adam Chodera on 20/06/2021.
 */
data class CommitResponse(
    @SerializedName("sha") val sha: String,
    @SerializedName("commit") val details: CommitDetailsResponse?
) {
    data class CommitDetailsResponse(
        @SerializedName("message") val message: String?
    )
}