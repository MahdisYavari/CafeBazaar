package com.example.interview.tools.network.api

import retrofit2.http.GET

//define retrofit api
interface MyApi {

    @GET()
    suspend fun getList()


}