package com.creator.movieapp

import API_KEY
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.creator.movieapp.api.RetrofitClient
import com.creator.movieapp.model.movie.MovieRepository
import com.creator.movieapp.model.movie.MovieViewModel
import com.creator.movieapp.ui.navigation.NavigationSystem
import com.creator.movieapp.ui.screens.homescreen.HomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val api = RetrofitClient.create()
        val repo = MovieRepository(api, API_KEY)
        val factory = MovieViewModel.Factory(repo)
        val vm = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        setContent {
            NavigationSystem(vm)
        }
    }
}
