package com.example.justcompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.justcompose.R


@Composable
fun ImageDemo() {
    Image(
        bitmap = imageResource(id = R.drawable.demo),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .clip(shape = RoundedCornerShape(50))
            .border(
                width = 2.dp,
                color = Color.White,
                shape = RoundedCornerShape(50)
            )
    )
}

@Preview
@Composable
fun previewImageDemo() {
    ImageDemo()
}

@Composable
fun VectorImageDemo() {
    Image(
        imageVector = vectorResource(id = R.drawable.ic_launcher_background),
        contentDescription = null,
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
    )


//    loadImageResource(id = R.drawable.cat).resource.resource?.let {
//        Image(
//                asset = it,
//                modifier = Modifier
//                        .width(200.dp)
//                        .height(200.dp)
//                        .clip(shape = shape)
//                        .border(
//                                width = 2.dp,
//                                color = Color.Red,
//                                shape = shape
//                        )
//        )
//    }
}

//@Preview
//@Composable
//fun previewVectorImageDemo() {
//    VectorImageDemo()
//}