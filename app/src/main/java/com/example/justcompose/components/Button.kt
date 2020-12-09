package com.example.justcompose.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Interaction
import androidx.compose.foundation.InteractionState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

data class ButtonState(var text: String, var textColor: Color, var buttonColor: Color)

//==================================================
@Composable
fun ButtonDemo() {

    val interactionState = remember { InteractionState() }

    val (text, textColor, buttonColor) = when {
        Interaction.Pressed in interactionState -> ButtonState(
            "Just Pressed", Color.Red, Color.Black
        )
        else -> ButtonState(
            "Just Button", Color.White, Color.Red
        )
    }

    Button(
        onClick = { },
        interactionState = interactionState,
        elevation = null,
        colors = ButtonConstants.defaultButtonColors(
            backgroundColor = buttonColor,
            disabledBackgroundColor = Color.Gray,
        ),
        modifier = Modifier
            .width(200.dp)
            .clip(RoundedCornerShape(50))
    ) {
        Text(
            text = text,
            color = textColor
        )
    }
}


@Preview
@Composable
fun previewButtonDemo() {
    Row() {
        ButtonDemo()

//        ButtonDemo()
    }

}

//==================================================
@Composable
fun IconButtonDemo() {
    IconButton(
        onClick = {},
    ) {
        Icon(Icons.Filled.Favorite)
        Text(text = "这是一个按钮")
    }
}

@Preview
@Composable
fun previewIconButton() {
    IconButtonDemo()
}

//==================================================
@Composable
fun IconToggleButtonDemo() {

    val checkedState = remember { mutableStateOf(true) }

    IconToggleButton(
        checked = checkedState.value,
        onCheckedChange = {
            Log.e("Button", "点击了：$it")
            checkedState.value = it
        },
    ) {
        Icon(
            asset = Icons.Filled.Favorite,
            tint = if (checkedState.value) {
                Color.Red
            } else {
                Color.Gray
            }
        )
    }
}

@Preview
@Composable
fun previewIconToggleButtonDemo() {
    IconToggleButtonDemo()
}

//==================================================
@Composable
fun TextButtonDemo() {
    TextButton(onClick = {}) {
        Text("Text Button")
    }
}

@Preview
@Composable
fun previewTextButtonDemo() {
    TextButtonDemo()
}

//==================================================
@Composable
fun OutlinedButtonDemo() {
    OutlinedButton(
        onClick = {},
        border = BorderStroke(2.dp, Color.Red),
        shape = RoundedCornerShape(50),
        colors = ButtonConstants.defaultButtonColors(
            backgroundColor = Color.Transparent
        )
    ) {
        Text(
            text = "Outlined Button",
            color = Color.Red
        )
    }
}

@Preview
@Composable
fun previewOutlinedButtonDemo() {
    OutlinedButtonDemo()
}