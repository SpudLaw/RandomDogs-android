package com.example.randomdogs

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.randomdogs.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel: DogViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.dogImage.observe(this, Observer {
            binding.imageView.setImageBitmap(it)
        })

        loadImage()

        binding.anotherDogButton.setOnClickListener {
            loadImage()
        }
    }

    private fun loadImage() {
        viewModel.fetchNewImage()
    }
}
