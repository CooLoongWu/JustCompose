package com.example.justcompose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.drawBorder
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.justcompose.R
import com.example.justcompose.ui.shapes


@Composable
fun ImageDemo() {

    val shape = CircleShape

    Image(
        asset = imageResource(id = R.drawable.cat),
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .clip(shape = shape)
            .border(
                width = 2.dp,
                color = Color.Red,
                shape = shape
            )
    )
}

@Preview
@Composable
fun previewImageView() {
    ImageDemo()
}