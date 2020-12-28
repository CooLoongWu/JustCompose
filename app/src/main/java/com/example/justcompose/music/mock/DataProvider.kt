package com.example.justcompose.music.mock

import com.example.justcompose.R
import com.example.justcompose.music.entity.ChatBean
import com.example.justcompose.music.entity.UserBean
import com.example.justcompose.music.entity.UserRoomBean

object DataProvider {

    val topics = arrayOf("余音绕梁，三日不绝", "被你的声音苏到了！", "快来看看")

    val chatBean = ChatBean(
        type = 0,
        userBean = UserBean("一半火焰", 0, R.drawable.avatar, 2),
        userRoomBean = UserRoomBean("主播", "公主", 4, 5),
        content = "欢迎来到我的直播间哦~"
    )

    val chatBean1 = ChatBean(
        type = 0,
        userBean = UserBean("火焰的一半_", 1, R.drawable.avatar, 2),
        userRoomBean = UserRoomBean("", "男爵", 4, 5),
        content = "被你的声音苏到了！"
    )

    val chatBean2 = ChatBean(
        type = 0,
        userBean = UserBean("辣妹的小场控", 0, R.drawable.avatar, 2),
        userRoomBean = UserRoomBean("管理员", "嫔妃", 4, 5),
        content = "欢迎各位来到直播间，给主播点点关注不迷路哦"
    )

    val chatList = arrayListOf<ChatBean>(
        chatBean, chatBean1, chatBean2, chatBean1, chatBean1,
        chatBean1, chatBean1, chatBean1, chatBean1, chatBean1,
    )

}