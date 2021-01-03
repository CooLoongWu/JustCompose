package com.example.justcompose.music.mock

import androidx.compose.runtime.mutableStateListOf
import com.example.justcompose.music.entity.ChatBean


/**
 * 聊天公屏区域内容变化
 */
class ChatUiState(
    private val chatBeans: List<ChatBean>
) {
    private val _chats: MutableList<ChatBean> =
        mutableStateListOf(*chatBeans.toTypedArray())

    val chats: List<ChatBean> = _chats

    fun addChat(chatBean: ChatBean) {
        _chats.add(chatBean)
    }
}