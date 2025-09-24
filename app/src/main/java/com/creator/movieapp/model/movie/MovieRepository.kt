package com.creator.movieapp.model.movie

import com.creator.movieapp.api.API_KEY
import com.creator.movieapp.api.ApiService

class MovieRepository(
    private val api: ApiService,
    private val apiKey: String
) {
    suspend fun getPopular(page: Int = 1): List<Movie> =
        api.getPopular(apiKey, page).results

    suspend fun getNowPlaying(page: Int = 1): List<Movie> =
        api.nowPlaying(apiKey, page).results

    suspend fun getUpcoming(page: Int = 1): List<Movie> =
        api.getUpcoming(apiKey, page).results

    suspend fun getTopRated(page: Int = 1): List<Movie> =
        api.getTopRated(apiKey, page).results

    suspend fun search(query: String, page: Int = 1): List<Movie> =
        api.search(apiKey, query, page).results
}