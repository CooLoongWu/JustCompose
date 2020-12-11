package com.example.justcompose.layout

import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.Dimension
import androidx.compose.foundation.layout.atMost
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ConstraintLayoutDemo() {
    ConstraintLayout {
        val (text1, text2, text3) = createRefs()

        Text(
            "Text1",
            Modifier.constrainAs(text1) {
                start.linkTo(text2.end, margin = 20.dp)
            }
        )
        Text(
            "Text2",
            Modifier.constrainAs(text2) {
                centerTo(parent)
            }
        )

        val barrier = createBottomBarrier(text1, text2)
        Text(
            "This is a very long text",
            Modifier.constrainAs(text3) {
                top.linkTo(barrier, margin = 20.dp)
                centerHorizontallyTo(parent)
                width = Dimension.preferredWrapContent.atMost(40.dp)
            }
        )
    }
}

@Preview
@Composable
fun previewConstraintLayoutDemo() {
    ConstraintLayoutDemo()
}