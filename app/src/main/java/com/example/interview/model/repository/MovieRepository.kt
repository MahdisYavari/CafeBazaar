package com.example.interview.model.repository

import com.example.interview.model.MovieResultItemModel
import com.example.interview.tools.base.BaseRepository
import com.example.interview.tools.db.room.MovieDao
import com.example.interview.tools.extensions.Mapper
import com.example.interview.tools.network.api.MovieApi
import com.example.interview.tools.network.entity.MovieResponse
import com.example.interview.tools.network.entity.MovieResultsItemResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDao: MovieDao,
    private val movieListMapper: Mapper<MovieResultsItemResponse, MovieResultItemModel>
) : BaseRepository() {

    private var moviesList = listOf<MovieResultItemModel>()
    private var movieItem: MovieResponse? = null


    fun getMoviesListFromServer(): List<MovieResultItemModel> {
        moviesList = movieItem?.results?.map(movieListMapper) ?: mutableListOf()
        return moviesList
    }

    suspend fun getMovieResponse() {
        movieItem = movieApi.getMovieItem()
    }

    suspend fun addMoviesListInDB() {
        movieDao.addMoviesList(moviesList)
    }

    suspend fun getMoviesListFromDB(): List<MovieResultItemModel> {
        moviesList = movieDao.getAllMovies()
        return moviesList
    }

    fun getMoviesList() = moviesList

}
