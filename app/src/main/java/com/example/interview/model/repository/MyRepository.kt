package com.example.interview.model.repository

import com.example.interview.tools.base.BaseRepository
import com.example.interview.tools.network.api.MyApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyRepository @Inject constructor(
    private val myApi: MyApi
    ) : BaseRepository() {

}
