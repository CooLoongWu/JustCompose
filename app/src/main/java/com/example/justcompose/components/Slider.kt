package com.example.justcompose.components

import androidx.compose.material.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.justcompose.ui.*

@Composable
fun SliderDemo() {
    val progress = remember { mutableStateOf(0f) }

    Slider(
        value = progress.value,
        onValueChange = {
            progress.value = it
        },
        thumbColor = myRed,
        inactiveTrackColor = myGray,
        activeTrackColor = myBlue,

        steps = 10,
        inactiveTickColor = myYellow,
        activeTickColor = Color.White
    )
}

@Preview
@Composable
fun previewSliderDemo() {
    SliderDemo()
}