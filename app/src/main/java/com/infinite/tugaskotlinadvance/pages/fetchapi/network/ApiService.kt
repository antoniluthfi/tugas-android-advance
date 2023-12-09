package com.infinite.tugaskotlinadvance.pages.fetchapi.network

import com.infinite.tugaskotlinadvance.pages.fetchapi.model.UserData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("v1/users")
    fun getUsers(): Call<List<UserData>>
}