package com.example.apistudiesproject.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieModel(
    @Json(name = "name") val name: String? = "",
    @Json(name = "imageUrl") val image: String? = ""
)
