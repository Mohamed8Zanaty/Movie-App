package com.creator.movieapp.api

import retrofit2.http.GET
import retrofit2.http.Query



interface ApiService {
    @GET("movie/popular")
    suspend fun getPopular(
        @Query("api_key") key: String,
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("movie/now_playing")
    suspend fun nowPlaying(
        @Query("api_key") key: String,
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("api_key") key: String,
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("api_key") key: String,
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("search/movie")
    suspend fun search(
        @Query("api_key") key: String,
        @Query("query") query: String,
        @Query("page") page: Int = 1
    ): MovieResponse

}

