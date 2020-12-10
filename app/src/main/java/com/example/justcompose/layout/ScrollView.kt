package com.example.justcompose.layout

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.ScrollableRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

//Scrollable中不允许嵌套使用Scrollable


/**
 *  java.lang.IllegalStateException:
 *  Nesting scrollable in the same direction layouts like ScrollableContainer and LazyColumnFor is not allowed.
 *  If you want to add a header before the list of items please take a look on LazyColumn component which has a DSL api which allows to first add a header via item() function and then the list of items via items().
 */

@Composable
fun ScrollableRowDemo() {
    ScrollableRow {
        Text(text = "Hello,This is just a Test,Great", color = Color.Red)
        Text(text = "Hello,,This is just another Test", color = Color.Blue)
        Text(text = "Hello", color = Color.Green)
        Text(text = "Hello")
        Text(text = "Hello")
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

@Preview
@Composable
fun previewScrollableColumnDemo() {
    ScrollableColumnDemo()
}