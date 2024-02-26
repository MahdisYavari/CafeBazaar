package com.example.interview.tools.network.entity

import com.google.gson.annotations.SerializedName

data class RatingResponse(

	@SerializedName("rate")
	val rate: Any? = null,

	@SerializedName("count")
	val count: Int? = null
)