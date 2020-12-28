package com.example.justcompose.music.entity

/**
 * 聊天实体类
 */
data class ChatBean(
    /**
     * 消息类型（0普通，1通知，2等等等）
     */
    val type: Int,

    /**
     * 用户信息
     */
    val userBean: UserBean,

    /**
     * 直播间的用户信息
     */
    val userRoomBean: UserRoomBean,

    /**
     * 发言内容，目前只处理String数据
     */
    val content: String,
)