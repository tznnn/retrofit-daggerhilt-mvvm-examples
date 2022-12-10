package com.example.apistudiesproject.data

import com.example.apistudiesproject.model.MovieModel
import com.example.apistudiesproject.network.MovieApiService
import javax.inject.Inject

class MovieRepo @Inject constructor(
    private val movieApiService: MovieApiService
) {
    suspend fun getMovie(): List<MovieModel> {
        return movieApiService.getMovie()
    }
}

