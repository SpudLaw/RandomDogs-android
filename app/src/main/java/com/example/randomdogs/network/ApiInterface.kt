package com.example.randomdogs.network

import com.example.randomdogs.data.RandomDogDataModel
import retrofit2.http.GET

interface ApiInterface {
    @GET("breeds/image/random")
    suspend fun fetchDogImage(): RandomDogDataModel
}