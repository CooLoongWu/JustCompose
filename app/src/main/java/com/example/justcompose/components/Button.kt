package com.example.justcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview


@Composable
fun ButtonDemo() {
    Button(
        onClick = {},
        modifier = Modifier.background(Color.Blue)
    ) {
        Text(text = "Just Button")
    }
}


@Preview
@Composable
fun previewButtonDemo() {
    ButtonDemo()
}

@Composable
fun IconButtonDemo() {
    IconButton(
        onClick = {},
    ) {
        Icon(Icons.Filled.Favorite)
    }
}

@Preview
@Composable
fun previewIconButton() {
    IconButtonDemo()
}

@Composable
fun IconToggleButtonDemo() {
    IconToggleButton(
        checked = true,
        onCheckedChange = {},
    ) {
        Icon(Icons.Filled.Favorite)
    }
}

@Preview
@Composable
fun previewIconToggleButtonDemo() {
    IconToggleButtonDemo()
}