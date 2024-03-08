package com.example.randomdogs.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.randomdogs.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


@Composable
fun DogScreen(modifier: Modifier = Modifier, urlState: Flow<String>, fetchNewImage: () -> Unit) {
    val url by urlState.collectAsState(initial = "")

    LaunchedEffect(Unit) { fetchNewImage() }
    Surface {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = url,
                contentDescription = "image of dog",
                modifier = Modifier.fillMaxSize(fraction = 0.9f)
            )
            OutlinedButton(onClick = { fetchNewImage() }) {
                Text(text = stringResource(id = R.string.another_random_dog))
            }
        }
    }
}

@Preview
@Composable
fun PreviewDogScreen() {
    DogScreen(urlState = flowOf("https://uploads.dailydot.com/2018/10/olli-the-polite-cat.jpg?auto=compress&fm=pjpg")) {
        println("asked to fetch new image")
    }
}