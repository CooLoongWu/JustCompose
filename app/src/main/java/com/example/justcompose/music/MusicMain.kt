package com.example.justcompose.music

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.justcompose.R
import com.example.justcompose.music.mock.ChatUiState
import com.example.justcompose.music.mock.DataProvider
import com.example.justcompose.ui.black20

@ExperimentalAnimationApi
@Composable
fun MainView() {

    //进场动效是否默认展示
    val enterRoom = remember { mutableStateOf(false) }

    val chatList = ChatUiState(DataProvider.chatList)

    val chatListState = rememberLazyListState(0, 1)


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
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
                modifier = Modifier
                    .fillMaxWidth()
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
                state = chatListState,
                verticalArrangement = Arrangement.Bottom
            ) {
                items(
                    count = chatList.chats.size,
                ) {
                    ChatItemView(chatBean = chatList.chats[it])
                }
            }

            /**
             * 底部的话题区域
             */
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .horizontalScroll(
                        rememberScrollState(
                            initial = 0f
                        )
                    )
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
                    chatList.addChat(DataProvider.chatBean)
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

//suspend fun scroll() {
//    chatListState.snapToItemIndex(4,1)
//}

@ExperimentalAnimationApi
@Preview
@Composable
fun previewMainView() {
    MainView()
}
