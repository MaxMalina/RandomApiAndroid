package com.exam.randomuser.data

import com.exam.randomuser.data.model.User
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomApi {
    @GET(Urls.BASE_URL)
    suspend fun getUsers(@Query("results") size: String): List<User>
}