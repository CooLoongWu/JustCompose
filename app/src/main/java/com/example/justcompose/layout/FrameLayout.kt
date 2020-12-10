package com.example.justcompose.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BoxDemo() {
    Box {
        Text(text = "你好")
        Text(text = "你很好")
    }
}

@Preview
@Composable
fun previewBoxDemo() {
    BoxDemo()
}