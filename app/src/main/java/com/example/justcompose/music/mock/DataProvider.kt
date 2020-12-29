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

    private val chatBean1 = ChatBean(
        type = 0,
        userBean = UserBean("天呐！公爵sama", 1, R.drawable.avatar, 2),
        userRoomBean = UserRoomBean("", "公爵", 4, 3),
        content = "在英国，公爵是仅次于国王或亲王的最高级贵族！"
    )

    private val chatBean2 = ChatBean(
        type = 0,
        userBean = UserBean("侯爵大人", 1, R.drawable.avatar, 2),
        userRoomBean = UserRoomBean("管理员", "侯爵", 4, 2),
        content = "而侯爵是到了15世纪，这级爵号稳定地保持了它在贵族爵位中的第二级地位以后，才被贵族们所看重。与其他4个等级的贵族相比，侯爵的数目一向最少。"
    )

    private val chatBean3 = ChatBean(
        type = 0,
        userBean = UserBean("是伯爵啊", 1, R.drawable.avatar, 2),
        userRoomBean = UserRoomBean("", "伯爵", 4, 1),
        content = "在英国5级贵族中，伯爵出现最早。个别学者认为伯爵爵位来自欧洲大陆，至迟在公元900年的法国，伯爵已成为公爵的封臣。"
    )

    private val chatBean4 = ChatBean(
        type = 0,
        userBean = UserBean("子爵用户专属", 1, R.drawable.avatar, 2),
        userRoomBean = UserRoomBean("", "子爵", 4, 0),
        content = "上院贵族中数子爵资格最浅。"
    )

    private val chatBean5 = ChatBean(
        type = 0,
        userBean = UserBean("你好男爵", 1, R.drawable.avatar, 2),
        userRoomBean = UserRoomBean("", "男爵", 4, 1),
        content = "英国男爵出现于11世纪。到12世纪初国王大部分高级世俗贵族都被封为男爵。"
    )

    private val chatBean6 = ChatBean(
        type = 0,
        userBean = UserBean("平平无奇的观众", 1, R.drawable.avatar, 0),
        userRoomBean = UserRoomBean("", "", 4, 5),
        content = "欢迎各位来到直播间，给主播点点关注不迷路哦"
    )

    val chatList = arrayListOf<ChatBean>(
        chatBean, chatBean1, chatBean2, chatBean3, chatBean4,
        chatBean5, chatBean6, chatBean6, chatBean6, chatBean6,
    )

}