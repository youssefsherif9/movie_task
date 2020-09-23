package com.example.moviestask

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
   var currentPage=1
    lateinit var adapter: adapter
    lateinit var manager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMovies()

    }


   fun getMovies() {
        Repo.service.getPopularMovies(page=currentPage).enqueue(object : Callback<response> {
            override fun onFailure(call: Call<response>, t: Throwable) {
                Toast.makeText(applicationContext,"fail to get movies", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<response>,
                response: Response<response>
            ) {
                if (response.body()!=null){
                    manager= LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                    adapter= adapter(response.body()!!.films)
                    recycler.adapter = adapter
                     recycler.layoutManager = manager
                Log.d("Popular Movies", "Movies: ${response.body()?.films}")
            } else{
                Log.d( "Popular Movies", "responseBody is null")
                }
            }

        })
    }
    fun scroll(){
        recycler.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                var totalPage: Int= manager.itemCount
                var itemview: Int= manager.childCount
                var firstItem: Int= manager.findFirstVisibleItemPosition()
                if(itemview+firstItem>=totalPage){
                recycler.removeOnScrollListener(this)
                    currentPage ++
                    getMovies()
                }
            }
        })

    }
}