package com.example.interview.tools.network.entity

import com.google.gson.annotations.SerializedName

data class MovieResponse(

	@SerializedName("dates")
	val dates: MovieDatesResponse? = null,

	@SerializedName("page")
	val page: Int? = null,

	@SerializedName("total_pages")
	val totalPages: Int? = null,

	@SerializedName("results")
	val results: List<MovieResultsItemResponse>? = null,

	@SerializedName("total_results")
	val totalResults: Int? = null
)