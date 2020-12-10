package com.example.justcompose.layout

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

val itemsStringList = (0..40).toList()

@Composable
fun LazyColumnDemo() {

    val itemsIntegerList = (0..5).toList()
    LazyColumn(content = {

        //可任意添加的Item
        item {
            Text(text = "这是随便添加的Text")
        }

        items(itemsIntegerList) {
            Text(text = "Item is a $it")
        }

        itemsIndexed(itemsStringList) { index, item ->
            Text(text = "Item at index $index is $item")
        }
    })
}

@Preview
@Composable
fun previewLazyColumnDemo() {
    LazyColumnDemo()
}

@Composable
fun LazyColumnForDemo() {
    LazyColumnFor(items = itemsStringList) {
        Text(text = "LazyColumnFor item is $it")
    }
}

@Composable
fun LazyColumnForIndexedDemo() {
    LazyColumnForIndexed(items = itemsStringList) { index, item ->
        Text(text = "LazyColumnFor item at index $index is $item")
    }
}