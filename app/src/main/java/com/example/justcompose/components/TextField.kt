package com.example.justcompose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.justcompose.ui.JustComposeTheme


@Composable
fun TextFieldDemo() {

    val focusRequester = FocusRequester()
    val textFieldValue = remember { mutableStateOf(TextFieldValue()) }

    TextField(
        value = textFieldValue.value,
        onValueChange = {
            textFieldValue.value = it
        },
        modifier = Modifier
            .focusRequester(focusRequester = focusRequester),
    )

    DisposableEffect(
        key1 = ""
    ) {
        focusRequester.requestFocus()

        onDispose {
        }
    }
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
    val textFieldValue = remember { mutableStateOf(TextFieldValue()) }

    OutlinedTextField(
        value = textFieldValue.value,
        onValueChange = {
            textFieldValue.value = it
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
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = null,
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = null,
                modifier = Modifier
                    .clickable(
                        onClick = {
                            textFieldValue.value = TextFieldValue("")
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


@Composable
fun BaseTextFieldDemo() {

    BasicTextField(value = "", onValueChange = { /*TODO*/ })
}