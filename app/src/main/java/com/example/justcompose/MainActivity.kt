package com.example.justcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

        CheckBoxDemo()
        Spacer(modifier = Modifier.height(20.dp))


        SwitchDemo()
        Spacer(modifier = Modifier.height(20.dp))

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