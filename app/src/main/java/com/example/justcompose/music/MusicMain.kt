package com.example.justcompose.music

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import com.example.justcompose.R
import com.example.justcompose.music.entity.ChatBean
import com.example.justcompose.music.mock.DataProvider
import com.example.justcompose.ui.black20

@ExperimentalAnimationApi
@Composable
fun MainView() {

    val enterRoom = remember { mutableStateOf(false) }

    val chatList = MutableLiveData<ArrayList<ChatBean>>()
    chatList.value = DataProvider.chatList


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
            val topicsView = createRef()
            val chatListView = createRef()
            val enterRomView = createRef()

            /**
             * 入场动画
             */
            Box(
                modifier = Modifier.fillMaxWidth()
                    .constrainAs(enterRomView) {
                        bottom.linkTo(chatListView.top)
                    }
            ) {
                EnterRoomLayout(
                    chatBean = DataProvider.chatBean,
                    isEnter = enterRoom.value
                )
            }

            /**
             * 公屏聊天区域
             */
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.7f)
                    .preferredHeight(100.dp)
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp, end = 0.dp)
                    .constrainAs(chatListView) {
                        bottom.linkTo(topicsView.top)
                    },
                verticalArrangement = Arrangement.Bottom
            ) {
                items(chatList.value!!) {
                    ChatItemView(chatBean = it)
                }
            }

            /**
             * 底部的话题区域
             */
            ScrollableRow(
                modifier = Modifier
                    .padding(16.dp)
                    .constrainAs(topicsView) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {

                repeat(DataProvider.topics.size) {
                    TopicItemView(topic = DataProvider.topics[it])
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }


            Button(
                onClick = {
                    enterRoom.value = !enterRoom.value
                },
                modifier = Modifier.constrainAs(createRef()) {
                    bottom.linkTo(parent.bottom)
                }

            ) {
                Text(text = "进入直播间")
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview
@Composable
fun previewMainView() {
    MainView()
}
