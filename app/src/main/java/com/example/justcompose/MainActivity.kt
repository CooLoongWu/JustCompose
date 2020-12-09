package com.example.justcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
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
    ScrollableColumn(modifier = Modifier.padding(52.dp)) {

        TextDemo(
            startString = JUST_LIKE_COMPOSE,
            endString = JUST_LOVE_COMPOSE
        )

        TextFieldDemo()

        OutlinedTextFieldDemo()

        IconDemo()

        ImageDemo()

        //Button相关
        Spacer(modifier = Modifier.height(20.dp))
        ButtonDemo()

        IconButtonDemo()

        IconToggleButtonDemo()

        Spacer(modifier = Modifier.height(20.dp))
        TextButtonDemo()
        Spacer(modifier = Modifier.height(20.dp))


        OutlinedButtonDemo()
    }
}

@Preview
@Composable
fun previewMainView() {
    mainView()
}