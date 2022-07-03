package com.by.data.api

import com.by.domain.entity.Movie
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("movielist.json")
    suspend fun getAllMovies() : Response<List<Movie>>
}