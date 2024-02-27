package com.example.interview.tools.network.api

import com.example.interview.tools.network.entity.MovieResponse
import com.example.interview.tools.network.entity.MovieResultsItemResponse
import retrofit2.http.GET
import retrofit2.http.Query

//define retrofit api
interface MovieApi {

    @GET("movie/upcoming")
    suspend fun getMovieItem(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): MovieResponse

}