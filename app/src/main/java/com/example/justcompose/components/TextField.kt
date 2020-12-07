package com.example.justcompose.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.justcompose.ui.JustComposeTheme


@Composable
fun TextFieldDemo() {

    var text by savedInstanceState { "" }

    TextField(
            value = text,
            onValueChange = {
                text = it
            },
//            label = {
//                Text("这是标签")
//            },
            placeholder = {
                Text("请输入内容")
            },
            modifier = Modifier.padding(8.dp),
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(asset = Icons.Filled.Lock)
            },
            trailingIcon = {
                Icon(
                        asset = Icons.Filled.Delete,
                        modifier = Modifier
                                .clickable(
                                        onClick = {
                                            text = ""
                                        }
                                )
                )
            },
    )
}

@Preview
@Composable
fun previewTextFieldDemo() {
    JustComposeTheme(darkTheme = false) {
        TextFieldDemo()
    }
}

@Composable
fun OutlinedTextFieldDemo() {
    var text by savedInstanceState { "" }

    OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
            },
//            label = {
//                Text("这是标签")
//            },
            placeholder = {
                Text("请输入内容")
            },
            modifier = Modifier.padding(8.dp),
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(asset = Icons.Filled.Lock)
            },
            trailingIcon = {
                Icon(
                        asset = Icons.Filled.Delete,
                        modifier = Modifier
                                .clickable(
                                        onClick = {
                                            text = ""
                                        }
                                )
                )
            },
    )
}

@Preview
@Composable
fun previewOutlinedTextFieldDemo() {
    OutlinedTextFieldDemo()
}