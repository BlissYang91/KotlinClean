package com.by.domain.util

import com.by.domain.entity.Movie

object ValidationUtil {
    fun validateMovie(movie: Movie) : Boolean {
        if (movie.name.isNotEmpty() && movie.category.isNotEmpty()) {
            return true
        }
        return false
    }
}