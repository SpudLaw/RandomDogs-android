package com.example.randomdogs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomdogs.network.ApiInterface
import com.example.randomdogs.network.ApiProvider
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {
    private val service: ApiInterface by lazy { ApiProvider.apiClient }

    var dogImage = MutableSharedFlow<String>(replay = 1)

    fun fetchNewImage() = viewModelScope.launch {
        val message = service.fetchDogImage().message
        dogImage.tryEmit(message)
    }
}


