package com.example.justcompose.layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.*
import com.example.justcompose.ui.*

@Composable
fun BoxDemo() {
    Box(
        modifier = Modifier
            .width(400.dp)
            .height(120.dp)
            .background(myBlue),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(color = myGreen)
                .paddingFromBaseline(top = 50.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(color = myYellow),
            )

            Text(
                modifier = Modifier.wrapContentSize(),
                text = "Compose",
                color = Color.White
            )
        }

        //水平分割线
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(color = myRed)
        )
    }
}

@Preview
@Composable
fun previewBoxDemo() {
    BoxDemo()
}


@Composable
fun BoxOffsetDemo() {
    Box(
        modifier = Modifier
            .width(400.dp)
            .height(120.dp)
            .background(myBlue),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(color = myGreen)
        ) {

            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(color = myYellow)
                    //注意顺序
                    .clip(RoundedCornerShape(20))
                    .clipToBounds()

            )

        }

        //水平分割线
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(color = myRed)
        )
    }
}


@Preview
@Composable
fun previewBoxOffsetDemo() {
    BoxOffsetDemo()
}

@Composable
fun GradientBox() {
    val colorList = arrayListOf(Color(0xFFFFCA1C), Color(0xFFED675C))
//    Box(
//        modifier = Modifier
//            .width(200.dp)
//            .height(50.dp)
//            .background(
//                brush = Brush.horizontalGradient(colorList),
//                shape = RoundedCornerShape(50)
//            )
//    )

    Box(
        modifier = Modifier
            .width(200.dp)
            .height(50.dp)
            .background(color = Color.White)
            .border(
                border = BorderStroke(
                    2.dp,
                    brush = Brush.horizontalGradient(colorList)
                ),
                shape = RoundedCornerShape(50)
            )
    )
}

@Preview
@Composable
fun previewGradientBox() {
    GradientBox()
}

@Composable
fun progressBox() {
    Box(
        modifier = Modifier
            .progressSemantics()
            .background(color = Color.Cyan)
    ) {
        Text("Operation is on progress")
    }
}