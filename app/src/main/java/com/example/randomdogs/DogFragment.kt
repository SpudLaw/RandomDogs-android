package com.example.randomdogs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navGraphViewModels
import coil.load
import com.example.randomdogs.databinding.FragmentDogBinding
import kotlinx.coroutines.launch

class DogFragment : Fragment(R.layout.fragment_dog) {
    private val viewModel by navGraphViewModels<DogViewModel>(R.id.main_graph)

    private var _binding: FragmentDogBinding? = null
    private val binding: FragmentDogBinding
        get() = _binding ?: FragmentDogBinding.bind(requireView()).also { _binding = it }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.dogImage.collect {
                    binding.imageView.load(it)
                }
            }
        }

        loadImage()

        binding.anotherDogButton.setOnClickListener {
            loadImage()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun loadImage() = viewModel.fetchNewImage()
}