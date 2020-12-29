package com.example.justcompose.music

import android.media.Image
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
import androidx.compose.ui.graphics.ImageBitmap
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

    val avatarBg: ImageBitmap?
    val appellationBg: ImageBitmap?

    when (chatBean.userRoomBean.appellation) {
        "公爵" -> {
            avatarBg = imageResource(id = R.drawable.avatar_bg_gong)
            appellationBg = imageResource(id = R.drawable.appellation_gong)
        }
        "侯爵" -> {
            avatarBg = imageResource(id = R.drawable.avatar_bg_hou)
            appellationBg = imageResource(id = R.drawable.appellation_hou)
        }
        "伯爵" -> {
            avatarBg = imageResource(id = R.drawable.avatar_bg_bo)
            appellationBg = imageResource(id = R.drawable.appellation_bo)
        }
        "子爵" -> {
            avatarBg = imageResource(id = R.drawable.avatar_bg_zi)
            appellationBg = imageResource(id = R.drawable.appellation_zi)
        }
        "男爵" -> {
            avatarBg = imageResource(id = R.drawable.avatar_bg_nan)
            appellationBg = imageResource(id = R.drawable.appellation_nan)
        }
        else -> {
            avatarBg = null
            appellationBg = null
        }
    }

    val guardText: String?
    val guardBg: ImageBitmap?
    when (chatBean.userRoomBean.guardLevel) {
        1 -> {
            guardText = "青铜"
            guardBg = imageResource(id = R.drawable.guard1)
        }
        2 -> {
            guardText = "黄金"
            guardBg = imageResource(id = R.drawable.guard2)
        }
        3 -> {
            guardText = "铂金"
            guardBg = imageResource(id = R.drawable.guard3)
        }
        else -> {
            guardText = null
            guardBg = null
        }
    }

    //当没有用户职位，封号，守护等级的时候，不展示标签布局
    val notShowMark = TextUtils.isEmpty(chatBean.userRoomBean.title) &&
            TextUtils.isEmpty(chatBean.userRoomBean.appellation) &&
            chatBean.userRoomBean.guardLevel == 0

    Row(
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Box(
            modifier = Modifier.size(52.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                bitmap = imageResource(id = chatBean.userBean.avatar),
                modifier = Modifier.fillMaxSize(0.8f)
                    .clip(RoundedCornerShape(50))
            )

            avatarBg?.let {
                Image(
                    bitmap = it,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Spacer(modifier = Modifier.width(4.dp))

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

            Spacer(modifier = Modifier.height(4.dp))

            if (!notShowMark) {
                Row(
                    modifier = Modifier.height(16.dp)
                ) {

                    //如果头衔不为空那么进行展示
                    if (!TextUtils.isEmpty(chatBean.userRoomBean.title)) {
                        Surface(
                            color = Color(0xFFFC2A56),
                            shape = RoundedCornerShape(2.dp),
                        ) {
                            Text(
                                text = chatBean.userRoomBean.title,
                                fontSize = 10.sp,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxHeight().padding(horizontal = 2.dp),
                            )
                        }

                        Spacer(modifier = Modifier.width(4.dp))
                    }

                    //展示用户封号
                    appellationBg?.let {
                        Box(
                            modifier = Modifier.fillMaxHeight(),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Icon(
                                bitmap = appellationBg,
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
                    }

                    guardBg?.let {
                        Box(
                            modifier = Modifier.fillMaxHeight(),
                            contentAlignment = Alignment.CenterEnd
                        ) {

                            Icon(
                                bitmap = guardBg,
                                tint = Color.Unspecified,
                                modifier = Modifier.fillMaxHeight(),
                            )

                            guardText?.let { it1 ->
                                Text(
                                    text = it1,
                                    color = Color.White,
                                    fontSize = 10.sp,
                                    modifier = Modifier.padding(0.dp, 0.dp, 4.dp, 0.dp)
                                )
                            }
                        }
                    }

                }

                Spacer(modifier = Modifier.height(6.dp))
            }

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