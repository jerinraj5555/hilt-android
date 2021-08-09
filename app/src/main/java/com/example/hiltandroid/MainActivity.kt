package com.example.hiltandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.example.hiltandroid.databinding.ActivityMainBinding
import com.example.hiltandroid.pref.DataStoreManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var movieAdapter: MovieAdapter
    private val viewModel : MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    @Inject lateinit var preferences: DataStoreManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeUiPreferences()
        binding.recyclerview.adapter = movieAdapter
        lifecycleScope.launch {
            preferences.setThemeMode(1)
        }


        viewModel.movieList.observe(this, Observer {
            movieAdapter.setMovies(it)
        })

        viewModel.progressBarStatus.observe(this, Observer {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
                lifecycleScope.launch {
                    preferences.setThemeMode(0)
                }
            }
        })

        viewModel.fetchAllMovies()
    }
    private fun observeUiPreferences() {
        preferences.themeMode.asLiveData().observe(this){
            when (it){
                1 ->{showMessage("Dark mode Activted..")}
                0 -> {showMessage("Dark mode De-activted..")}
            }
        }
        viewModel.getAllMoviesListFromDb().asLiveData().observe(this){
            movieAdapter.setMovies(it)
        }
    }

    private fun showMessage(s: String) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
    }
}