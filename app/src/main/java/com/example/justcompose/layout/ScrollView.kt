package com.example.justcompose.layout

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//Scrollable中不允许嵌套使用Scrollable


/**
 *  java.lang.IllegalStateException:
 *  Nesting scrollable in the same direction layouts like ScrollableContainer and LazyColumnFor is not allowed.
 *  If you want to add a header before the list of items please take a look on LazyColumn component which has a DSL api which allows to first add a header via item() function and then the list of items via items().
 */

@Composable
fun ScrollableRowDemo() {

    val list = arrayOf(0, 1, 2, 3, 4)

    ScrollableRow(
        contentPadding = PaddingValues(10.dp)
    ) {
        repeat(list.count()) {
            Box(
                Modifier
                    .height(100.dp)
                    .width(150.dp)
                    .background(
                        if (it % 2 == 0) {
                            Color.Yellow
                        } else {
                            Color.Red
                        }
                    )
            )
        }
    }
}

@Preview
@Composable
fun previewScrollableRowDemo() {
    ScrollableRowDemo()
}

@Composable
fun ScrollableColumnDemo() {
    ScrollableColumn() {
        Text(text = "Hello,This is just a Test,Great", color = Color.Red)
        Text(text = "Hello,,This is just another Test", color = Color.Blue)
        Text(text = "Hello", color = Color.Green)
        Text(text = "Hello")
        Text(text = "Hello")
    }
}

//@Preview
//@Composable
//fun previewScrollableColumnDemo() {
//    ScrollableColumnDemo()
//}