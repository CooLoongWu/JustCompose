package com.example.justcompose.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.justcompose.R


@Composable
fun IconDemo() {
    Icon(
        asset = Icons.Filled.Edit,
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
    )
}

@Preview
@Composable
fun previewIconDemo() {
    IconDemo()
}