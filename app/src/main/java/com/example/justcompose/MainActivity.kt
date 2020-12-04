package com.example.justcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.example.justcompose.components.*
import com.example.justcompose.ui.JustComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JustComposeTheme {
               mainView()
            }
        }
    }
}

@Composable
fun mainView() {
    Column {
        TextDemo(
            startString = JUST_LIKE_COMPOSE,
            endString = JUST_LOVE_COMPOSE
        )

        TextFieldDemo()

        ButtonDemo()

        IconDemo()

        ImageDemo()

        IconButtonDemo()

        IconToggleButtonDemo()
    }
}

@Preview
@Composable
fun previewMainView() {
    mainView()
}