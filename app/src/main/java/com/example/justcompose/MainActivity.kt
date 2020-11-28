package com.example.justcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.example.justcompose.components.JUST_LIKE_COMPOSE
import com.example.justcompose.components.JUST_LOVE_COMPOSE
import com.example.justcompose.components.TextDemo
import com.example.justcompose.ui.JustComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JustComposeTheme {
                TextDemo(startString = JUST_LIKE_COMPOSE, endString = JUST_LOVE_COMPOSE)
            }
        }
    }
}