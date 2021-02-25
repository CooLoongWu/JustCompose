package com.example.justcompose.anim

import android.widget.Space
import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun VisibilityTransitionDemo(visible: Boolean) {

    val state = remember { mutableStateOf(false) }
    val alpha = animateFloatAsState(if (state.value) 0f else 1f)
    Text(
        text = "Visibility Transition",
        modifier = Modifier
            .alpha(alpha.value)
            .clickable(onClick = {
                state.value = !state.value
            }),
        fontSize = 50.sp
    )
}

@ExperimentalAnimationApi
@Composable
fun AnimatedVisibilityDemo() {

    val visible = remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {

        Spacer(modifier = Modifier.height(200.dp))
        Text(
            text =
            if (visible.value) {
                "出场动画"
            } else {
                "入场动画"
            },
            modifier = Modifier
                .clickable(onClick = {
                    visible.value = !visible.value
                })
        )

        Spacer(modifier = Modifier.height(20.dp))

        AnimatedVisibility(
            visible = visible.value,
            enter = slideInHorizontally() + fadeIn(),
            exit = slideOutHorizontally() + fadeOut()
        ) {
            Text(
                text = "Compose is coming!",
                fontSize = 32.sp
            )
        }


    }
}

@ExperimentalAnimationApi
@Composable
fun previewAnim() {
    AnimatedVisibilityDemo()
}