package com.example.hiltandroid.repo

import com.example.hiltandroid.data.Movie
import kotlinx.coroutines.flow.Flow

interface LocalRepo {
    suspend fun insertAll(movieList:List<Movie>)
    fun getAllArticles(): Flow<List<Movie>>
}