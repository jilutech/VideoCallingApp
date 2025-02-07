package com.example.videocallingapp.connect

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

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
                TODO()
            }
            is ConnectAction.OnNameChange -> {
                TODO()
            }
        }
    }

}