package com.by.myapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.by.myapp.databinding.AdapterMovieBinding
import com.by.myapp.domain.Movie
import com.by.myapp.util.ValidationUtil
import javax.inject.Inject

class MovieAdapter @Inject constructor() : RecyclerView.Adapter<MainViewHolder>(){
    private var movieList = mutableListOf<Movie>()

    fun setMovies(movies: List<Movie>) {
        this.movieList = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

//        val movie = movieList[position]
//        holder.binding.name.text = movie.name
        val movie = movieList[position]
        if (ValidationUtil.validateMovie(movie)) {
            holder.binding.name.text = movie.name
            Glide.with(holder.itemView.context)
                .load(movie.imageUrl)
//            .skipMemoryCache(false)
//                .placeholder(R.drawable.ic_launcher_background)
//                .centerCrop()
                .override(200,200)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存资源
//                .error(com.google.android.material.R.drawable.abc_btn_check_to_on_mtrl_000)
//            .dontTransform()//这个方法就是取消图片变化效果
//            .format(DecodeFormat.PREFER_ARGB_8888)//设置图片解码格式
                .into(holder.binding.imageview)
//                .into(TransformationUtils(holder.binding.imageview).target)
        }

    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {}