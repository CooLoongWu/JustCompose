package com.example.justcompose.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TopAppBarDemo() {
    TopAppBar(
        title = { Text("Simple TopAppBar") },
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.ArrowBack)
            }
        },
        actions = {
            // RowScope here, so these icons will be placed horizontally
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Favorite)
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Favorite)
            }
        }
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
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Icons.Filled.Menu)
        }
        // The actions should be at the end of the BottomAppBar
        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Icons.Filled.Favorite)
        }
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Icons.Filled.Favorite)
        }
    }
}

@Preview
@Composable
fun previewBottomAppBarDemo() {
    BottomAppBarDemo()
}