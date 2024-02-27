package com.example.interview.model

import com.example.interview.tools.network.entity.MovieDatesResponse
import com.example.interview.tools.network.entity.MovieResultsItemResponse


class MovieModel(
    val id: Int ?= null,
    val dates: MovieDatesResponse? = null,
    val page: Int? = null,
    val totalPages: Int? = null,
    val results: List<MovieResultsItemResponse?>? = null,
    val totalResults: Int? = null
)