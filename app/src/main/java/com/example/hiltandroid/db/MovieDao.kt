package com.example.hiltandroid.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hiltandroid.data.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movieList:List<Movie>)

    @Query("SELECT * FROM movie")
    fun getAllArticles(): Flow<List<Movie>>
}