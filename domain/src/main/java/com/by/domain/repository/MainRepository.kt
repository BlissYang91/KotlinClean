package com.by.domain.repository

import com.by.domain.entity.Movie
import retrofit2.Response

interface MainRepository {
    suspend fun getAllMovies() : Response<List<Movie>>
}