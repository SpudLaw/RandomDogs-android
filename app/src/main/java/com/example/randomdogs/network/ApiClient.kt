package com.example.randomdogs.network

class ApiProvider {
    companion object {
        val apiClient: ApiInterface by lazy { ApiInterface() }
    }
}