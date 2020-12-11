package com.example.justcompose.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
        modifier = Modifier
            .width(360.dp)
            .height(200.dp)
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        //子Box1
        Box(
            modifier = Modifier
                .fillMaxSize(0.5f)
                .background(color = Color.Black)
        )

        //子Box2
        Box(
            modifier = Modifier
                .fillMaxSize(0.2f)
                .background(color = Color.White)
        )
    }
}

@Preview
@Composable
fun previewBoxDemo() {
    BoxDemo()
}