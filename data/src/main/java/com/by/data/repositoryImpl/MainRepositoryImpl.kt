package com.by.data.repositoryImpl

import com.by.data.api.ApiService
import com.by.domain.entity.Movie
import com.by.domain.repository.MainRepository
import retrofit2.Response
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val apiService: ApiService) : MainRepository {
    override suspend fun getAllMovies(): Response<List<Movie>> = apiService.getAllMovies()
}