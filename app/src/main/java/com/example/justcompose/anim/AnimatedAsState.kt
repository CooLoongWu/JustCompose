package com.example.justcompose.anim

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.justcompose.ui.myBlue

@Composable
fun AnimatedDpAsState() {

    val big = remember { mutableStateOf(false) }

    val width: Dp by animateDpAsState(
        if (big.value) {
            300.dp
        } else {
            120.dp
        }
    )

    Box(
        modifier = Modifier
            .height(50.dp)
            .width(width)
            .alpha(1f)
            .rotate(
                if (big.value) {
                    45f
                } else {
                    -45f
                }
            )
            .scale(if (big.value) {
                1f
            } else {
                2f
            })
//            .width(
//                if (big.value) {
//                    300.dp
//                } else {
//                    120.dp
//                }
//            )
            .background(color = myBlue)
            .clickable {
                big.value = !big.value
            }
    )
}