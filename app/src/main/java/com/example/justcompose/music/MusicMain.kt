package com.example.justcompose.music

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.justcompose.R
import com.example.justcompose.music.entity.ChatBean
import com.example.justcompose.music.entity.UserBean
import com.example.justcompose.music.entity.UserRoomBean
import com.example.justcompose.music.mock.DataProvider
import com.example.justcompose.ui.black20


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
            val chats = createRef()

            /**
             * 公屏聊天区域
             */
            LazyColumnFor(
                items = DataProvider.chatList,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.8f)
                    .preferredHeight(100.dp)
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp, end = 0.dp)
                    .constrainAs(chats) {
                        bottom.linkTo(topics.top)
                    },
            ) {
                ChatItemView(chatBean = it)
            }

            /**
             * 底部的话题区域
             */
            ScrollableRow(
                modifier = Modifier
                    .padding(16.dp)
                    .constrainAs(topics) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {

                repeat(DataProvider.topics.size) {
                    TopicItemView(topic = DataProvider.topics[it])
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
