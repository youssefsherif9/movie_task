package com.example.moviestask
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
interface ApiSer {
    @GET("movie/popular")
fun getPopularMovies(@Query( "api_key") apiKey : String="25cad71c6989632e1fa574ea672621b5"
    ,@Query("page")page:Int):Call<response>

}