package com.example.moviestask

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repo {
    val BASE_URL = "https://api.themoviedb.org/3"
    val service: ApiSer
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(ApiSer::class.java)
    }
}