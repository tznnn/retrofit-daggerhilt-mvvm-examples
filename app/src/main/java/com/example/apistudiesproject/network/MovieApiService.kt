package com.example.apistudiesproject.network

import com.example.apistudiesproject.ApiConstant.END_POINT
import com.example.apistudiesproject.model.MovieModel
import retrofit2.http.GET

interface MovieApiService {
    @GET(END_POINT)
    suspend fun getMovie(): List<MovieModel>
}