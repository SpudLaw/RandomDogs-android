package com.example.randomdogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.randomdogs.screen.LayoutChoice
import com.example.randomdogs.screen.LayoutChoiceScreen

class LayoutDecisionFragment : Fragment() {

    private val onLayoutChoice = { it: LayoutChoice ->
        val navId = when (it) {
            LayoutChoice.Compose -> R.id.dog_screen_compose
            LayoutChoice.Xml -> R.id.dog_screen_xml
        }
        findNavController().navigate(navId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        id = View.generateViewId()
        setViewCompositionStrategy(DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            MaterialTheme {
                LayoutChoiceScreen(onChoice = onLayoutChoice)
            }
        }
    }
}