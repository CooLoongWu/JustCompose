package com.example.justcompose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TabRowDemo() {
    var state = remember { mutableStateOf(0) }
    val titles = listOf("TAB 1", "TAB 2", "TAB 3 WITH LOTS OF TEXT")
    Column {
        TabRow(selectedTabIndex = state.value) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = state.value == index,
                    onClick = { state.value = index }
                )
            }
        }
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Text tab ${state.value + 1} selected",
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview
@Composable
fun previewTabRowDemo() {
    TabRowDemo()
}

@Composable
fun ScrollableTabRowDemo() {
    var state = remember { mutableStateOf(0) }
    val titles = listOf("TAB 1", "TAB 2", "TAB 3 WITH LOTS OF TEXT")
    Column {
        ScrollableTabRow(
            selectedTabIndex = state.value,
            modifier = Modifier.wrapContentWidth(),
            edgePadding = 16.dp
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = state.value == index,
                    onClick = { state.value = index }
                )
            }
        }
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Text tab ${state.value + 1} selected",
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview
@Composable
fun previewScrollableTabRow() {
    TabRowDemo()
}