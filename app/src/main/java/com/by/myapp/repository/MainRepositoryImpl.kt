package com.by.myapp.repository

import com.by.myapp.datasource.ApiService
import com.by.myapp.domain.Movie
import retrofit2.Response
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val apiService: ApiService) : MainRepository{
    override suspend fun getAllMovies(): Response<List<Movie>> = apiService.getAllMovies()
}