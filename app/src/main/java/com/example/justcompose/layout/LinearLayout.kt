package com.example.justcompose.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


//横向布局
@Composable
fun RowDemo() {
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(scrollState),
    ) {
        Box(
            Modifier
                .height(200.dp)
                .weight(1f)
                .background(Color.Red)
        )
        Box(
            Modifier
                .height(100.dp)
                .weight(1f)
                .background(Color.Yellow)
        )
    }
}

@Preview
@Composable
fun previewRowDemo() {
    RowDemo()
}

@Composable
fun ColumnDemo() {
    Column {
        Text(text = "Hello,This is just a Test,Great", color = Color.Red)
        Text(text = "Hello,,This is just another Test", color = Color.Blue)
        Text(text = "Hello", color = Color.Green)
    }
}

//@Preview
//@Composable
//fun previewColumnDemo() {
//    ColumnDemo()
//}


//还在实验阶段的瀑布流布局
@ExperimentalLayout
@Composable
fun FlowColumnDemo() {

    val sizes = arrayOf("1", "2", "3", "4", "5")

//    FlowColumn(
//        mainAxisSpacing = 10.dp,
//        crossAxisSpacing = 10.dp
//    ) {
//        sizes.forEach {
//            Box(
//                Modifier
//                    .preferredSize(10.dp, 20.dp)
//                    .background(Color.Magenta)
//            )
//        }
//    }
}

//@Preview
//@ExperimentalLayout
//@Composable
//fun previewFlowColumnDemo() {
//    FlowColumnDemo()
//}