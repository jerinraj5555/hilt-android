package com.example.hiltandroid.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "movie"
)
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val name: String,
    val imageUrl: String,
    val category: String)