package com.example.videocallingapp

import android.app.Application
import io.getstream.video.android.core.StreamVideo
import io.getstream.video.android.core.StreamVideoBuilder
import io.getstream.video.android.model.User
import io.getstream.video.android.model.UserType
import java.util.stream.Stream

class VideoCallingApp : Application(){

    private var currentName: String? = null
    var  client: StreamVideo? = null


    fun initVideoClient(userName: String){
        if (client == null || userName != currentName){
              StreamVideo.removeClient()
              currentName = userName
              client = StreamVideoBuilder(
                  context = this,
                  apiKey = "evvjqs6d28c3",
                  user = User(
                      id = userName,
                      name = userName,
                      type = UserType.Guest)
              ).build()
        }
    }
}