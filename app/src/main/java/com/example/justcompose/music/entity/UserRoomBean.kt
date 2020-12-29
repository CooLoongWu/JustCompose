package com.example.justcompose.music.entity

/**
 * 针对本直播间的用户信息
 * 包括在本直播间的称号、守护等级、聊天等级、用户职位【主播、管理员等】、
 */
data class UserRoomBean(

    /**
     * 用户职位
     * 【0普通用户、1主播、2管理员】
     */
    val title: String,

    /**
     * 称谓【公爵，侯爵，伯爵，子爵，男爵等】
     */
    val appellation: String,

    /**
     * 聊天等级
     */
    val chatLevel: Int,

    /**
     * 守护等级
     */
    val guardLevel: Int,
)