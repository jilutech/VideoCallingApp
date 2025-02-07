package com.example.videocallingapp.connect

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.videocallingapp.ui.theme.VideoCallingAppTheme

@Composable
fun ConnectScreen(
    modifier: Modifier = Modifier,
    state: ConnectState,
    onAction: (ConnectAction) -> Unit


){

}


@Preview
@Composable
private fun ConnectScreenPreview(){
    VideoCallingAppTheme {
        ConnectScreen()
    }
}