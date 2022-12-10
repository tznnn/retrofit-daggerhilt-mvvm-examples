package com.example.apistudiesproject.network

import com.example.apistudiesproject.ApiConstant.END_POINT
import retrofit2.http.GET

interface ApiService {
    @GET(END_POINT)
    suspend fun getMoview():List
}