package com.example.justcompose.music

import android.text.TextUtils
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.justcompose.R
import com.example.justcompose.music.entity.ChatBean
import com.example.justcompose.music.mock.DataProvider
import com.example.justcompose.ui.black50


/**
 * 话题item视图
 */
@Composable
fun TopicItemView(topic: String) {
    Button(
        onClick = {},
        elevation = null,
        colors = ButtonConstants.defaultButtonColors(
            backgroundColor = black50
        ),
        shape = RoundedCornerShape(50)
    ) {
        Text(
            text = topic,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.alpha(0.8f)
        )
    }
}

@Preview
@Composable
fun previewTopicView() {
    TopicItemView(topic = DataProvider.topics[0])
}


/**
 * 公屏聊天Item视图
 */
@Composable
fun ChatItemView(chatBean: ChatBean) {
    Row(
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Box(
            modifier = Modifier.size(52.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                bitmap = imageResource(id = chatBean.userBean.avatar),
                modifier = Modifier.size(42.dp).clip(RoundedCornerShape(50))
            )

            //头像标志
            Image(
                bitmap = imageResource(id = R.drawable.avatar_bg),
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Column {

            val genderColor = if (chatBean.userBean.gender == 0) {
                Color(0xFFD9B6BA)
            } else {
                Color.White
            }

            Text(
                text = chatBean.userBean.nickname,
                fontSize = 14.sp,
                color = genderColor,
                modifier = Modifier.alpha(0.8f),
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.height(16.dp)
            ) {

                //如果头衔不为空那么进行展示
                if (!TextUtils.isEmpty(chatBean.userRoomBean.title)) {
                    Box(
                        modifier = Modifier.fillMaxHeight()
                            .background(color = Color(0xFFFC2A56))
                            .clip(shape = RoundedCornerShape(2.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = chatBean.userRoomBean.title,
                            fontSize = 10.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(2.dp).fillMaxHeight(),
                        )
                    }

                    Spacer(modifier = Modifier.width(4.dp))
                }

                Box(
                    modifier = Modifier.fillMaxHeight(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Icon(
                        bitmap = imageResource(id = R.drawable.appellation),
                        tint = Color.Unspecified,
                        modifier = Modifier.fillMaxHeight(),
                    )

                    Text(
                        text = chatBean.userRoomBean.appellation,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(0.dp, 0.dp, 4.dp, 0.dp)
                    )
                }


                Spacer(modifier = Modifier.width(4.dp))

                Box(
                    modifier = Modifier.fillMaxHeight(),
                    contentAlignment = Alignment.CenterEnd
                ) {

                    val imageBitmap = if (chatBean.userRoomBean.guardLevel > 4) {
                        R.drawable.guard1
                    } else {
                        R.drawable.guard2
                    }

                    Icon(
                        bitmap = imageResource(imageBitmap),
                        tint = Color.Unspecified,
                        modifier = Modifier.fillMaxHeight(),
                    )

                    Text(
                        text = "守卫",
                        color = Color.White,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(0.dp, 0.dp, 4.dp, 0.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            //评论内容区域
            Surface(
                color = black50,
                shape = RoundedCornerShape(
                    topLeft = 0.dp,
                    topRight = 8.dp,
                    bottomLeft = 8.dp,
                    bottomRight = 8.dp
                )
            ) {
                Text(
                    modifier = Modifier.padding(8.dp).alpha(0.8f),
                    text = chatBean.content,
                    color = Color.White,
                    fontSize = 14.sp,
                )
            }
        }
    }
}

@Preview
@Composable
fun previewChatItemView() {

    ChatItemView(chatBean = DataProvider.chatBean)
}