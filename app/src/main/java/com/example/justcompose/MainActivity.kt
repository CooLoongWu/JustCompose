package com.example.justcompose

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.justcompose.components.*
import com.example.justcompose.layout.*
import com.example.justcompose.ui.JustComposeTheme
import com.example.justcompose.ui.black50
import com.example.justcompose.ui.black80
import com.example.justcompose.utils.BarUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置状态栏透明
        BarUtil.execStatusBarTranslucent(this)

        setContent {
            JustComposeTheme {

                Column() {

                    Spacer(modifier = Modifier.height(200.dp))
                    LazyRowDemo()
                }
            }
        }

    }
}

@Composable
fun mainLayout() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            bitmap = imageResource(R.drawable.year),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .background(black80)
        )


        Column(
            modifier = Modifier
                .padding(0.dp, 52.dp, 0.dp, 0.dp)
        ) {
//        RowDemo()
//
//        ColumnDemo()

            ScrollableRowDemo()

            ScrollableColumnDemo()

            BoxDemo()

//        LazyColumnDemo()

//        LazyColumnForDemo()

//            LazyColumnForIndexedDemo()
        }
    }


}

@Composable
fun mainView() {
    ScrollableColumn(modifier = Modifier.padding(52.dp)) {

        CheckBoxDemo()
        Spacer(modifier = Modifier.height(20.dp))


        SwitchDemo()
        Spacer(modifier = Modifier.height(20.dp))

        TextDemo(
            startString = JUST_LIKE_COMPOSE,
            endString = JUST_LOVE_COMPOSE
        )

        TextFieldDemo()

        OutlinedTextFieldDemo()

        IconDemo()

        ImageDemo()

        //Button相关
        Spacer(modifier = Modifier.height(20.dp))
        ButtonDemo()

        IconButtonDemo()

        IconToggleButtonDemo()

        Spacer(modifier = Modifier.height(20.dp))
        TextButtonDemo()
        Spacer(modifier = Modifier.height(20.dp))


        OutlinedButtonDemo()

    }
}

@Preview
@Composable
fun previewMainView() {
    mainView()
}