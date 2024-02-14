package com.example.randomdogs.data

import kotlinx.serialization.Serializable

@Serializable
data class RandomDogDataModel(val message: String, val status: String)