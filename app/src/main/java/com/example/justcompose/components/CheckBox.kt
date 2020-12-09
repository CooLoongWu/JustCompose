package com.example.justcompose.components

import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CheckBoxDemo() {
    val checkedState = remember { mutableStateOf(true) }
    Checkbox(
        checked = checkedState.value,
        onCheckedChange = {
            checkedState.value = it
        }
    )
}

@Preview
@Composable
fun previewCheckBoxDemo() {
    CheckBoxDemo()
}