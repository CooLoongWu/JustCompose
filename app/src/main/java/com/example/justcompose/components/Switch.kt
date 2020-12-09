package com.example.justcompose.components

import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SwitchDemo() {
    val checkedState = remember { mutableStateOf(true) }

    Switch(
        checked = checkedState.value,
        onCheckedChange = {
            checkedState.value = it
        }
    )
}

@Preview
@Composable
fun previewSwitchDemo() {
    SwitchDemo()
}