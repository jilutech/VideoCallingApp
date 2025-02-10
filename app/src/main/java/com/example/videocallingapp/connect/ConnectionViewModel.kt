package com.example.videocallingapp.connect

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.videocallingapp.VideoCallingApp

class ConnectionViewModel(
    private val app: Application
): AndroidViewModel(
    app
) {

    var state by mutableStateOf(ConnectState())
        private set


    fun onAction(action: ConnectAction){
        when(action){
            ConnectAction.OnConnectClick -> {
               connectedToRoom()
            }
            is ConnectAction.OnNameChange -> {
                 state = state.copy(name = action.name)
            }
        }
    }

    private fun connectedToRoom(){
        state = state.copy(errorMessage = null)
        if (state.name.isBlank()){
            state = state.copy(
                errorMessage = "Username can't be blank"
            )
            return
        }

        // Init video client

        (app as VideoCallingApp).initVideoClient(state.name)

        state = state.copy(isConnected = true)

    }

}