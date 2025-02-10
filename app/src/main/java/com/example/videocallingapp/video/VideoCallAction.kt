package com.example.videocallingapp.video

import com.example.videocallingapp.VideoCallingApp

sealed interface VideoCallAction {
    data object OnDisconnectClick: VideoCallAction
    data object JoinCall: VideoCallAction
}