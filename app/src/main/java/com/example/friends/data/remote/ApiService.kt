package com.example.friends.data.remote

import com.example.friends.domain.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.BASE_URL)
    suspend fun getAllUsers(@Query("results") results: String): UserModelDao

}