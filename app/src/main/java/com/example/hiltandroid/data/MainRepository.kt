package com.example.hiltandroid.data

import retrofit2.Response

interface MainRepository {
    suspend fun getAllMovies() : Response<List<Movie>>
}