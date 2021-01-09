package com.example.justcompose.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopAppBarDemo() {
    TopAppBar(
        title = { Text("这是标题") },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.ArrowBack)
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Share)
            }
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Settings)
            }
        },
        elevation = 0.dp
    )
}

@Preview
@Composable
fun previewTopAppBarDemo() {
    TopAppBarDemo()
}

@Composable
fun BottomAppBarDemo() {
    BottomAppBar {
        Text(text = "底部标题栏")
        Spacer(Modifier.weight(1f, true))

        IconButton(onClick = { }) {
            Icon(Icons.Filled.Favorite)
        }
    }
}

@Preview
@Composable
fun previewBottomAppBarDemo() {
    BottomAppBarDemo()
}