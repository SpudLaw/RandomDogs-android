package com.example.randomdogs.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.randomdogs.R


enum class LayoutChoice {
    Compose,
    Xml;
}

@Composable
fun LayoutChoiceScreen(modifier: Modifier = Modifier, onChoice: (LayoutChoice) -> Unit) {
    Surface {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            OutlinedButton(onClick = { onChoice(LayoutChoice.Xml) }) {
                Text(text = stringResource(id = R.string.xml_based))
            }
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(onClick = { onChoice(LayoutChoice.Compose) }) {
                Text(text = stringResource(id = R.string.compose_based))
            }
        }
    }
}

@Preview
@Composable
fun PreviewLayoutChoiceScreen() {
    LayoutChoiceScreen(onChoice = { println("Choice $it") })
}