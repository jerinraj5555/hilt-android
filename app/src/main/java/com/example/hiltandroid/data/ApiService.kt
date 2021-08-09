package com.example.hiltandroid.data

import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("movie_list")
    suspend fun getAllMovies() : Response<List<Movie>>
}