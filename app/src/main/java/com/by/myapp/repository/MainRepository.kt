package com.by.myapp.repository

import com.by.myapp.domain.Movie
import retrofit2.Response

interface MainRepository {
    suspend fun getAllMovies() : Response<List<Movie>>
}