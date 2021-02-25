package com.example.justcompose.layout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.justcompose.ui.myBlue
import com.example.justcompose.ui.myRed

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
//    LazyColumnFor(items = itemsStringList) {
//        Text(text = "LazyColumnFor item is $it")
//    }
}

@ExperimentalFoundationApi
@Composable
fun LazyVerticalGridDemo() {
    val listData = (0..4).toList()

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.padding(horizontal = 0.dp, vertical = 80.dp)
    ) {
        items(listData) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
                    .background(
                        color = when {
                            it % 2 == 0 -> {
                                myBlue
                            }
                            else -> {
                                myRed
                            }
                        }
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "列表项：$it"
                )
            }
        }
    }
}
//
//@Composable
//fun LazyColumnForIndexedDemo() {
//    LazyColumnForIndexed(items = itemsStringList) { index, item ->
//        Text(text = "LazyColumnFor item at index $index is $item")
//    }
//}