package com.example.moviestask
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import kotlinx.android.synthetic.main.card.view.*

class adapter(private var movies:MutableList<movie>): RecyclerView.Adapter<adapter.MovieHolder>() {
class MovieHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun onBind(film:movie){
itemView.movie_name.text=film.name
itemView.movie_date.text =film.date
    itemView.movie_rating.text=film.rate.toString()
    Glide.with(itemView)
        .load("https://image.tmdb.org/t/p/w342${film.posterpath}")
        .transform(CenterCrop())
            .into(itemView.movie_image)
    }
}



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder
        = MovieHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.card,
                parent,
                false
            ))


    override fun getItemCount(): Int=movies.size
    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        var film=movies[position]
        holder.onBind(film)
    }
    fun append(mez:List<movie>){
        this.movies.addAll(mez)
        notifyItemRangeChanged(movies.size,movies.size-1)
    }
}