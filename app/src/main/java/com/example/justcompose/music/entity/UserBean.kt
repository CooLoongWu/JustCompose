package com.example.justcompose.music.entity

/**
 * 用户实体类
 */
data class UserBean(
    /**
     * 用户昵称
     */
    val nickname: String,

    /**
     * 性别，（0女，1男）
     */
    val gender: Int,

    /**
     * 头像资源，目前使用本地资源
     */
    val avatar: Int,

    /**
     * 规则等级
     */
    val level: Int,
)