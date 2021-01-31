package com.example.justcompose.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DropdownMenuDemo() {
    var expanded = remember { mutableStateOf(false) }

    val iconButton = @Composable {
        IconButton(onClick = { expanded.value = true }) {
            Icon(Icons.Default.MoreVert,
                contentDescription = null,)
        }
    }

    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false },
        toggle = iconButton,
    ) {
        DropdownMenuItem(onClick = { }) {
            Text("分享")
        }
        DropdownMenuItem(onClick = { }) {
            Text("举报")
        }
        DropdownMenuItem(onClick = { }) {
            Text("关注")
        }
    }
}

@Preview
@Composable
fun previewDropdownMenuDemo() {
    DropdownMenuDemo()
}