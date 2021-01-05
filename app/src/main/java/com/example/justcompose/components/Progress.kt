package com.example.justcompose.components

import androidx.compose.animation.animate
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProgressCircularDemo() {
    val rememberProgress = remember { mutableStateOf(0.1f) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        CircularProgressIndicator(
            progress = rememberProgress.value
        )

        Spacer(Modifier.height(30.dp))
        TextButton(onClick = {
            if (rememberProgress.value < 1f) rememberProgress.value += 0.1f
        }) {
            Text(text = "增加进度")
        }
    }
}

@Composable
fun ProgressCircularLoopDemo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ProgressLinearDemo() {
    val rememberProgress = remember { mutableStateOf(0.1f) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        LinearProgressIndicator(
            progress = rememberProgress.value
        )

        Spacer(Modifier.height(30.dp))
        TextButton(onClick = {
            if (rememberProgress.value < 1f) rememberProgress.value += 0.1f
        }) {
            Text(text = "增加进度")
        }
    }
}

@Composable
fun ProgressLinearLoopDemo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        LinearProgressIndicator()
    }
}

@Preview
@Composable
fun previewProgressDemo() {
    ProgressCircularDemo()
}