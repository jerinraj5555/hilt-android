package com.example.hiltandroid.repo

import com.example.hiltandroid.data.Movie
import com.example.hiltandroid.db.MovieDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalRepoImpl @Inject constructor (private val dao: MovieDao):LocalRepo {
    override suspend fun insertAll(movieList: List<Movie>) {
        dao.insertAll(movieList)
    }

    override fun getAllArticles(): Flow<List<Movie>> {
        return dao.getAllArticles()
    }
}