package com.example.justcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.justcompose.anim.AnimatedDpAsState
import com.example.justcompose.custom.*
import com.example.justcompose.layout.BoxDemo
import com.example.justcompose.layout.ScrollableColumnDemo
import com.example.justcompose.layout.ScrollableRowDemo
import com.example.justcompose.music.MainView
import com.example.justcompose.ui.JustComposeTheme
import com.example.justcompose.ui.black80
import com.example.justcompose.utils.BarUtil

class MainActivity : AppCompatActivity() {

    @ExperimentalMaterialApi
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
//                    DropdownMenuDemo()
//                    ImageDemo()
//                    VectorImageDemo()
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


//                    TextFieldDemo()

//                    ScaffoldDemo()
//                    Scaffold2Demo()
//                    Scaffold3Demo()
//                    Scaffold4Demo()
//                    Scaffold5Demo()
//                    Surface(
//                        modifier = Modifier.size(200.dp),
//                        color = myBlue,
//                        elevation = 20.dp,
//                        shape = RoundedCornerShape(10.dp)
//                    ) {
//
//                    }

//                    SliderDemo()
//                    AnimatedDpAsState()
//                    CanvasDemo()
                    DrawImageDemo()
//                    DrawLineDemo()
//                    DrawOvalDemo()
//                    DrawPathDemo()
                    DrawPointsDemo()
                    DrawReactDemo()
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
            painter = painterResource(R.drawable.year),
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
