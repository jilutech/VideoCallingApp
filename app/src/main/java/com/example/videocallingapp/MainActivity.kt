package com.example.videocallingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.videocallingapp.connect.ConnectScreen
import com.example.videocallingapp.connect.ConnectionViewModel
import com.example.videocallingapp.ui.theme.VideoCallingAppTheme
import com.example.videocallingapp.video.CallState
import com.example.videocallingapp.video.VideoCallViewModel
import com.example.videocallingapp.video.VideoScreen
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VideoCallingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                     val navController = rememberNavController()
                     NavHost(navController = navController, startDestination = ConnectRoute){
                         composable<ConnectRoute>(){
                            val viewModel = koinViewModel<ConnectionViewModel>()
                             val state = viewModel.state

                             LaunchedEffect(key1 = state.isConnected) {
                                 if (state.isConnected){
                                     navController.navigate(VideoCallRoute){
                                         popUpTo(ConnectRoute){
                                             inclusive = true
                                         }
                                     }
                                 }
                             }
                             ConnectScreen(state = state, onAction = viewModel::onAction)
                         }
                         composable<VideoCallRoute>() {

                             val viewModel = koinViewModel<VideoCallViewModel>()
                             val state = viewModel.state

                             LaunchedEffect(key1 = state.callState) {
                                 if (state.callState == CallState.ENDED){
                                     navController.navigate(ConnectRoute){
                                         popUpTo(VideoCallRoute)
                                         {
                                             inclusive = true
                                         }
                                     }
                                 }
                             }
                             VideoScreen(state=state, onAction = viewModel::onAction)
                         }
                     }
                }
            }
        }
    }
}

@Serializable
data object ConnectRoute

@Serializable
data object VideoCallRoute