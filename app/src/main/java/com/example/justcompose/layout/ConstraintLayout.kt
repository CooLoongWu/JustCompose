package com.example.justcompose.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
//    ConstraintLayoutDemo()
    ConstraintLayoutIdDemo()
}

@Composable
fun ConstraintLayoutIdDemo() {
    ConstraintLayout(
        ConstraintSet {
            val box1 = createRefFor("box1")
            val box2 = createRefFor("box2")
            val box3 = createRefFor("box3")

            constrain(box1) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }

            constrain(box2) {
                top.linkTo(box1.bottom)
                start.linkTo(parent.start)
            }

            val barrier = createEndBarrier(box1, box2)

            constrain(box3) {
                start.linkTo(barrier)
                top.linkTo(box1.top)
                bottom.linkTo(box2.bottom)
            }
        }
    ) {
        Box(
            modifier = Modifier.layoutId("box1")
                .background(color = Color.Red)
                .width(200.dp)
                .height(100.dp)
        )
        Box(
            modifier = Modifier.layoutId("box2")
                .background(color = Color.Yellow)
                .width(150.dp)
                .height(100.dp)
        )
        Box(
            modifier = Modifier.layoutId("box3")
                .background(color = Color.Blue)
                .width(200.dp)
                .height(100.dp)
        )
    }
}