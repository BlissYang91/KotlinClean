package com.by.myapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.by.myapp.domain.Movie
import com.by.myapp.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {
    private val movieList = MutableLiveData<List<Movie>>()
    private val progressBarStatus = MutableLiveData<Boolean>()

    fun fetchAllMovies(){
        progressBarStatus.value = true
        viewModelScope.launch {
            val response = mainRepository.getAllMovies()
            if (response.isSuccessful) {
                movieList.postValue(response.body())
                progressBarStatus.value = false
            }
        }

    }
    fun getMovieList() : MutableLiveData<List<Movie>> {
        return movieList;
    }

    fun getProgressBarStatus() : MutableLiveData<Boolean> {
        return progressBarStatus
    }
}