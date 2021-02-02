package com.example.justcompose

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.setContent

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            val clickTimes = remember { mutableStateOf(0) }

            Text(text = "点击了按钮 ${clickTimes.value}")

            Button(onClick = { clickTimes.value++ }) {

            }
        }
    }

    fun test1() {

        var clickTimes = 0

        val textView = TextView(this)
        val button = Button(this)

        button.setOnClickListener {
            clickTimes++
            textView.text = "点击了按钮 $clickTimes"
        }
    }
}