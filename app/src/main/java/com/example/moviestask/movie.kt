package com.example.moviestask
import com.google.gson.annotations.SerializedName
data class movie(
    @SerializedName("id") val id: Long,
@SerializedName("overview") val overview: String,
@SerializedName("poster_path") val posterpath: String,
@SerializedName("backdrop_path") val backdroppath: String,
@SerializedName("vote_average") val rate: Float,
@SerializedName("release_date") val date: String,
    @SerializedName("title") val name: String
)
