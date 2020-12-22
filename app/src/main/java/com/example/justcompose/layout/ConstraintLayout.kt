package com.example.justcompose.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ConstraintLayoutDemo() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {

        val guideline = createGuidelineFromStart(0.2f)
        val (box1, box2) = createRefs()

        Box(
            modifier = Modifier.fillMaxSize()
                .background(color = Color.Yellow)
                .constrainAs(box1) {
                    end.linkTo(guideline)
                }
        )

        Box(
            modifier = Modifier.fillMaxSize()
                .background(color = Color.Red)
                .constrainAs(box2) {
                    start.linkTo(guideline)
                }
        )

//        val (text1, text2, text3) = createRefs()
//
//        Text(
//            "Text1",
//            Modifier.constrainAs(text1) {
//                start.linkTo(text2.end, margin = 20.dp)
//            }
//        )
//        Text(
//            "Text2",
//            Modifier.constrainAs(text2) {
//                centerTo(parent)
//            }
//        )
//
//        val barrier = createBottomBarrier(text1, text2)
//        Text(
//            "This is a very long text",
//            Modifier.constrainAs(text3) {
//                top.linkTo(barrier, margin = 20.dp)
//                centerHorizontallyTo(parent)
//                width = Dimension.preferredWrapContent.atMost(40.dp)
//            }
//        )
    }
}

@Preview
@Composable
fun previewConstraintLayoutDemo() {
    ConstraintLayoutDemo()
}