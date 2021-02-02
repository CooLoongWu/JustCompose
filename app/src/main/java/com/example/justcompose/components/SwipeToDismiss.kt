package com.example.justcompose.components

import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


@ExperimentalMaterialApi
@Composable
fun SwipeToDismissDemo() {

    val unread = remember { mutableStateOf(false) }
    val dismissState = rememberDismissState(
        confirmStateChange = {
            if (it == DismissValue.DismissedToEnd) unread.value = !unread.value
            it != DismissValue.DismissedToEnd
        }
    )

    SwipeToDismiss(state = dismissState, background = { /*TODO*/ }) {

    }
}