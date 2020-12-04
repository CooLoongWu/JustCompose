package com.example.justcompose.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.TextFieldValue
import androidx.ui.tooling.preview.Preview


@Composable
fun TextFieldDemo() {

    var text by savedInstanceState { "" }

    TextField(
            value = text,
            label = {
                Text("标签")
            },
            placeholder = {
                Text("请输入内容")
            },
            leadingIcon = {
                Icon(Icons.Filled.Favorite)
            },
            trailingIcon = {
                Icon(
                        asset = Icons.Filled.Delete,
                        modifier = Modifier.clickable(
                                onClick = {
                                    Log.e("TextField", "点击了尾部标签")
                                    text = ""
                                }))
            },
            onValueChange = {
                text = it
            })
}

@Preview
@Composable
fun previewTextFieldDemo() {
    TextFieldDemo()
}