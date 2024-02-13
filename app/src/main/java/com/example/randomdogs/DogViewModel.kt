package com.example.randomdogs

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.randomdogs.network.ApiClient.Companion.getApiClient
import com.example.randomdogs.network.ApiInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class DogViewModel: ViewModel() {
    private val lazyService: ApiInterface by lazy {
        getApiClient().create(ApiInterface::class.java)
    }

    var dogImage = MutableLiveData<Bitmap>()

    fun fetchNewImage() {
        CoroutineScope(Dispatchers.IO).launch {
            val url = URL(lazyService.fetchDogImage().message)
            val image = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            dogImage.postValue(image)
        }
    }
}


