package com.by.myapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.by.myapp.R
import com.by.myapp.adapter.MovieAdapter
import com.by.myapp.databinding.ActivityMainBinding
import com.by.myapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var movieAdapter: MovieAdapter
    private val viewModel : MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.adapter = movieAdapter

        viewModel.getMovieList().observe(this, Observer {
            movieAdapter.setMovies(it)
        })

        viewModel.getProgressBarStatus().observe(this, Observer {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        })

        viewModel.fetchAllMovies()
    }
}