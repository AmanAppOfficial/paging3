package com.example.myretrofit.dao

import com.example.myretrofit.model.Git
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

public interface ApiInterface {
    @GET("issues")
    suspend fun getList(@Query("page") page: Int): Response<List<Git>>
}