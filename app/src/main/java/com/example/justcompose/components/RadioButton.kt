package com.example.justcompose.components

import android.widget.RadioButton
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RadioButtonDemo() {
    //涉及到Content
//    var state by remember { mutableStateOf(true) }
//    Row {
//        RadioButton(
//            selected = state,
//            onClick = { state = true }
//        )
//        RadioButton(
//            selected = !state,
//            onClick = { state = false }
//        )
//    }
}

@Preview
@Composable
fun previewRadioButtonDemo() {
    RadioButtonDemo()
}