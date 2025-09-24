package com.creator.movieapp.api

import com.creator.movieapp.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(@SerializedName("results") val results: List<Movie>)
