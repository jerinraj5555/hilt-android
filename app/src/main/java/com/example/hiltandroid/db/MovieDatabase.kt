package com.example.hiltandroid.db
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hiltandroid.data.Movie

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
//@TypeConverters(Converters::class)
abstract  class MovieDatabase : RoomDatabase(){
    abstract fun getMovies():MovieDao
}

