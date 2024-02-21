package com.example.randomdogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.randomdogs.screen.DogScreen

class DogComposeFragment : Fragment() {

    private val viewModel by activityViewModels<DogViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            DogScreen(urlState = viewModel.dogImage) {
                viewModel.fetchNewImage()
            }
        }
    }
}