package com.example.interview.tools.network.entity

import com.google.gson.annotations.SerializedName

data class ProductResponse(

	@SerializedName("ProductResponse")
	val productResponse: List<ProductResponseItem?>? = null
)