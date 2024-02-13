package com.example.randomdogs.data

import com.squareup.moshi.Json

data class RandomDogDataModel(@field:Json(name = "message") val message: String,
                              @field:Json(name = "status") val status: String)