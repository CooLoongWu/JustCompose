package com.example.justcompose.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawOpacity
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

const val JUST_LIKE_COMPOSE = "Just Like Compose."
const val JUST_LOVE_COMPOSE = "Just Love Compose."


@Composable
fun TextDemo(startString: String, endString: String) {

    val annotatedString = AnnotatedString.Builder(startString)
    annotatedString.pushStyle(
            SpanStyle(
                    color = Color.Blue,
                    fontSize = 24.sp,
                    fontStyle = FontStyle.Italic
            )
    )
    annotatedString.append("【BLUE】")
    annotatedString.pop()
    annotatedString.append(endString)

    Text(
            text = annotatedString.toAnnotatedString(),
            color = Color.Red,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
//            textDecoration = TextDecoration.Underline,
//            letterSpacing = 0.2.em,
//            lineHeight = 2.em,
            maxLines = 5,
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                    .height(200.dp)
                    .drawOpacity(0.5f)
                    .padding(16.dp)
                    .clickable(onClick = {
                        Log.e("点击了全文本", "点击事件")
                    })
                    .background(color = Color.Yellow)

    )
}

@Preview
@Composable
fun previewTextDemo() {
    TextDemo(startString = JUST_LIKE_COMPOSE, endString = JUST_LOVE_COMPOSE)
}