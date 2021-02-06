package com.example.justcompose.components

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.text.SoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
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


@Composable
fun BaseTextFieldDemo() {

    BasicTextField(value = "", onValueChange = { /*TODO*/ })
}