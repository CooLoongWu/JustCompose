package com.example.justcompose.components

import android.widget.RadioButton
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtonDemo() {
    val tags = arrayListOf("Java", "Kotlin", "XML", "Compose", "JetPack")
    var selectedTag = remember { mutableStateOf("Null") }

    Row() {
        tags.forEach {
            Row {
                RadioButton(
                    selected = it == selectedTag.value,
                    onClick = {
                        selectedTag.value = it
                    }
                )

                Text(text = it)
            }

            Spacer(modifier = Modifier.width(20.dp))
        }
    }
}

@Preview
@Composable
fun previewRadioButtonDemo() {
    RadioButtonDemo()
}