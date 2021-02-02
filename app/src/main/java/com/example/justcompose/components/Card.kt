package com.example.justcompose.components

import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CardDemo() {
    Card {
        Text(text = "This is a card")
    }
}

@Preview
@Composable
fun previewCardDemo() {
    CardDemo()
}