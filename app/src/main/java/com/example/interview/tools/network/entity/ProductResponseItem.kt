package com.example.interview.tools.network.entity

import com.google.gson.annotations.SerializedName

data class ProductResponseItem(

    @SerializedName("image")
	val image: String? = null,

    @SerializedName("price")
	val price: Double? = null,

    @SerializedName("rating")
	val ratingResponse: RatingResponse? = null,

    @SerializedName("description")
	val description: String? = null,

    @SerializedName("id")
	val id: Int? = null,

    @SerializedName("title")
	val title: String? = null,

    @SerializedName("category")
	val category: String? = null
)