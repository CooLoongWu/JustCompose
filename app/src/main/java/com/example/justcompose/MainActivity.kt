package com.example.justcompose

import android.os.Bundle
import android.widget.Space
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.justcompose.components.*
import com.example.justcompose.layout.*
import com.example.justcompose.music.MainView
import com.example.justcompose.music.entity.ChatBean
import com.example.justcompose.ui.JustComposeTheme
import com.example.justcompose.ui.black80
import com.example.justcompose.utils.BarUtil

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //设置状态栏透明
        BarUtil.execStatusBarTranslucent(this)

        setContent {
            JustComposeTheme {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 92.dp)

                ) {
//
////                    TopAppBarDemo()
////
////                    Spacer(modifier = Modifier.height(20.dp))
////                    BottomAppBarDemo()
//////
////                    TabRowDemo()
////
////                    Spacer(modifier = Modifier.height(20.dp))
////
////                    ScrollableTabRowDemo()
//
////                    DropdownMenuDemo()
//
////                    ProgressCircularDemo()
////
////                    Spacer(modifier = Modifier.height(50.dp))
////                    ProgressCircularLoopDemo()
////                    Spacer(modifier = Modifier.height(50.dp))
////
////                    ProgressLinearDemo()
////                    Spacer(modifier = Modifier.height(50.dp))
////                    ProgressLinearLoopDemo()
////                    Spacer(modifier = Modifier.height(50.dp))
//
////                    RadioButtonDemo()
//                    LazyVerticalGridDemo()


                    TextFieldDemo()
                }

//                MainView()

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
            contentDescription = null,
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

//@Preview
//@Composable
//fun previewMainView() {
////    mainView()
//}