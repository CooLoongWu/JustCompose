package com.example.justcompose.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.justcompose.ui.netEasyColor

@Composable
fun BoxDemo() {
    Box(
        modifier = Modifier.fillMaxSize().background(netEasyColor),
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier.width(30.dp)
                .fillMaxSize(0.5f)
                .background(color = Color.Magenta)
        )
    }
}

@Preview
@Composable
fun previewBoxDemo() {
    BoxDemo()
}