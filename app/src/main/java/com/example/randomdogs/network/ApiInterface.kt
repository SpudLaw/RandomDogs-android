package com.example.randomdogs.network

import com.example.randomdogs.data.RandomDogDataModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ApiInterface {
    companion object {
        private const val BASE_URL = "https://dog.ceo/api"
    }

    private val client by lazy {
        HttpClient(OkHttp) {
            expectSuccess = true
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    suspend fun fetchDogImage() =
        client.get("$BASE_URL/breeds/image/random").body<RandomDogDataModel>()
}