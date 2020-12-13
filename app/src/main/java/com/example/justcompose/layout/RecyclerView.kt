package com.example.justcompose.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val itemsStringList = (0..40).toList()

@Composable
fun LazyRowDemo() {

    val listData = (0..9).toList()
    LazyRow(content = {

        //头部内容
        item {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "头部")
            }
        }

        //列表内容
        items(listData) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(
                        if (it % 2 == 0) {
                            Color.Red
                        } else {
                            Color.Yellow
                        }
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = "列表项：$it")
            }
        }

        //尾部内容
        item {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "尾部")
            }
        }
    })
}

@Preview
@Composable
fun previewLazyRowDemo() {
    LazyRowDemo()
}

@Composable
fun LazyColumnForDemo() {
    LazyColumnFor(items = itemsStringList) {
        Text(text = "LazyColumnFor item is $it")
    }
}
//
//@Composable
//fun LazyColumnForIndexedDemo() {
//    LazyColumnForIndexed(items = itemsStringList) { index, item ->
//        Text(text = "LazyColumnFor item at index $index is $item")
//    }
//}