package com.example.justcompose.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardDemo() {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(50.dp)
    ) {
        Text(text = "This is a card")
    }
}

@Preview
@Composable
fun previewCardDemo() {
    CardDemo()
}