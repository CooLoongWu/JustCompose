package com.example.justcompose.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.justcompose.R


@Composable
fun IconDemo() {
    Icon(
        bitmap = imageResource(id = R.drawable.fire),
        contentDescription = null,
        modifier = Modifier
            .width(24.dp)
            .height(24.dp),
        tint = Color.Unspecified
    )
}

@Composable
fun IconDemo2() {

    //ImageBitmap居然没找到相应的类

    Icon(
        bitmap = imageResource(id = R.drawable.fire),
        contentDescription = null,
        tint = Color.Unspecified
    )
}

@Preview
@Composable
fun previewIconDemo() {
    IconDemo()
}

@Preview
@Composable
fun previewIconDemo2() {
    IconDemo2()
}