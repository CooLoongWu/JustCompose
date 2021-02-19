package com.example.justcompose.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

const val JUST_LIKE_COMPOSE = "Just Like Compose."
const val JUST_LOVE_COMPOSE = "Just Love Compose."

@Composable
fun simpleText() {
    Text(
            text = "Hi, Compose",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
//            textDecoration = TextDecoration.Underline,
//            letterSpacing = 0.2.em,
//            lineHeight = 2.em,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
//            modifier = Modifier
////                    .fillMaxWidth()
////                    .height(200.dp)
//                    .drawOpacity(1f)//透明度0-1
////                    .padding(16.dp)
//                    .clickable(onClick = {
//                        Log.e("点击了全文本", "点击事件")
//                    })
//                    .background(color = Color.Yellow)
    )
}

@Preview
@Composable
fun previewSimpleText() {
    simpleText()
}


@Composable
fun TextDemo(startString: String, endString: String) {
    val annotatedStringBuilder = AnnotatedString.Builder(startString)
    annotatedStringBuilder.pushStyle(
            SpanStyle(
                    color = Color.Red,
                    fontSize = 24.sp,
                    fontStyle = FontStyle.Italic,
            )
    )
    annotatedStringBuilder.append("【可以】")
    annotatedStringBuilder.pop()
    annotatedStringBuilder.append(endString)
    val annotatedString = annotatedStringBuilder.toAnnotatedString()

    Text(
            text = annotatedString,
//            color = Color.Red,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            style = TextStyle(
                    color = Color.White,
                    background = Color.DarkGray
            ),
            modifier = Modifier
                    .width(200.dp)
                    .height(100.dp)
                    .wrapContentSize(align = Alignment.CenterEnd)
                    .alpha(1f)
                    .clickable(onClick = {
                        Log.e("点击了全文本", "点击事件")
                    })
                    .background(color = Color.Yellow)
    )
}

@Preview
@Composable
fun previewTextDemo() {
    TextDemo(startString = "你", endString = "的")
}