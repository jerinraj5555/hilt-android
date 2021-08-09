package com.example.hiltandroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hiltandroid.data.MainRepository
import com.example.hiltandroid.data.Movie
import com.example.hiltandroid.repo.LocalRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository,
                                        private val localRepo : LocalRepo
                                        ): ViewModel() {

    val movieList = MutableLiveData<List<Movie>>()
    val progressBarStatus = MutableLiveData<Boolean>()

    fun fetchAllMovies() {
        progressBarStatus.value = true
        CoroutineScope(Dispatchers.IO).launch {
            val response = mainRepository.getAllMovies()
            if (response.isSuccessful) {
                //movieList.postValue(response.body())
                response.body()?.let { localRepo.insertAll(it) }
            }
        }
        progressBarStatus.value = false
    }
    fun getAllMoviesListFromDb() = localRepo.getAllArticles()


}