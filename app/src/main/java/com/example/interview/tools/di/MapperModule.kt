package com.example.interview.tools.di

import com.example.interview.model.MovieModel
import com.example.interview.model.MovieResultItemModel
import com.example.interview.tools.extensions.Mapper
import com.example.interview.tools.network.entity.MovieResponse
import com.example.interview.tools.network.entity.MovieResultsItemResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideMovie(): Mapper<MovieResponse, MovieModel> =
        {
            MovieModel(
                totalPages = it.totalPages,
                totalResults = it.totalResults,
                page = it.page,
                results = it.results
            )
        }

    @Provides
    @Singleton
    fun provideMovieResult(): Mapper<MovieResultsItemResponse, MovieResultItemModel> =
        {
            MovieResultItemModel(
                id = it.id,
                title = it.title,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                originalTitle = it.originalTitle
            )
        }
}