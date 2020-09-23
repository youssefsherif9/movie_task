package com.example.moviestask

import com.google.gson.annotations.SerializedName

data class response(
    @SerializedName("results") val films:MutableList<movie>,

    @SerializedName("pages") val presentPage:Int,

@SerializedName("total_pages") val total:Int

)