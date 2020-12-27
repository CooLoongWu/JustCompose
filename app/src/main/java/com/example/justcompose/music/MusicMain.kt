package com.example.justcompose.music

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonConstants
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.justcompose.R
import com.example.justcompose.ui.black10
import com.example.justcompose.ui.black20
import com.example.justcompose.ui.black50
import com.example.justcompose.ui.black80

val topicTitles = arrayOf("余音绕梁，三日不绝", "被你的声音苏到了！", "快来看看")


@Composable
fun MainView() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            bitmap = imageResource(id = R.drawable.bg),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .background(black20)
        )


        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val topics = createRef()


            //底部的话题控件
            ScrollableRow(
                modifier = Modifier
                    .padding(16.dp)
                    .constrainAs(topics) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {

                repeat(topicTitles.size) {
                    TopicButton(topic = topicTitles[it])
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun previewMainView() {
    MainView()
}


@Composable
fun TopicButton(topic: String) {
    Button(
        onClick = {},
        elevation = null,
        colors = ButtonConstants.defaultButtonColors(
            backgroundColor = black20
        ),
        shape = RoundedCornerShape(50)
    ) {
        Text(
            text = topic,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}

@Preview
@Composable
fun previewTopicView() {
    TopicButton(topic = topicTitles[0])
}