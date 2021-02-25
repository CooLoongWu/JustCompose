package com.example.justcompose.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.justcompose.R



@Composable
fun IconDemo3() {
    Icon(
        imageVector = Icons.Outlined.Face,
        contentDescription = null,
        modifier = Modifier
            .width(24.dp)
            .height(24.dp),
        tint = Color.Unspecified
    )
}


@Composable
fun IconDemo() {
    Icon(
        painter = painterResource(id = R.drawable.fire),
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
        painter = painterResource(id = R.drawable.fire),
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


@Preview
@Composable
fun previewIconDemo3() {
    IconDemo3()
}