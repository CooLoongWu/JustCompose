package com.example.justcompose.anim

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@Composable
fun AnimatedSlideInOut() {
    var visible = remember { mutableStateOf(true) }

    AnimatedVisibility(
        visible.value,
        enter = slideIn(
            // Specifies the starting offset of the slide-in to be 1/4 of the width to the right,
            // 100 (pixels) below the content position, which results in a simultaneous slide up
            // and slide left.
            { fullSize -> IntOffset(fullSize.width / 4, 100) },
            tween(1000, easing = LinearOutSlowInEasing)
        ),
        exit = slideOut(
            // The offset can be entirely independent of the size of the content. This specifies
            // a target offset 180 pixels to the left of the content, and 50 pixels below. This will
            // produce a slide-left combined with a slide-down.
            { IntOffset(-180, 50) },
            tween(1000, easing = FastOutSlowInEasing)
        )
    ) {
        // Content that needs to appear/disappear goes here:
        Text(
            "Content to appear/disappear",
            Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clickable(onClick = {
                    visible.value = !visible.value
                })
        )
    }
}

@Composable
fun CrossfadeDemo() {
//    Crossfade(current = "A") { screen ->
//        when (screen) {
//            "A" -> Text(text = "PageA")
//            "B" -> Text(text = "PageB")
//        }
//    }
}