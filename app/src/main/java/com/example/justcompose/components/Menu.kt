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
            Icon(Icons.Default.MoreVert)
        }
    }

    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false },
        toggle = iconButton,
        toggleModifier = Modifier.wrapContentSize(Alignment.BottomStart)
    ) {
        DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
            Text("Refresh")
        }
        DropdownMenuItem(onClick = { /* Handle settings! */ }) {
            Text("Settings")
        }
//        Divider()
        DropdownMenuItem(onClick = { /* Handle send feedback! */ }) {
            Text("Send Feedback")
        }
    }
}

@Preview
@Composable
fun previewDropdownMenuDemo() {
    DropdownMenuDemo()
}