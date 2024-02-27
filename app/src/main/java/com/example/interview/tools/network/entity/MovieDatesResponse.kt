package com.example.interview.tools.network.entity

import com.google.gson.annotations.SerializedName

data class MovieDatesResponse(

	@SerializedName("maximum")
	val maximum: String? = null,

	@SerializedName("minimum")
	val minimum: String? = null
)