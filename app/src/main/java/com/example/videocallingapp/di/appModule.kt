package com.example.videocallingapp.di

import com.example.videocallingapp.VideoCallingApp
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf

import org.koin.dsl.module


import com.example.videocallingapp.video.VideoCallViewModel
import com.example.videocallingapp.connect.ConnectionViewModel

val appModule = module {
    factory {
        val app = androidContext().applicationContext as VideoCallingApp
        app.client
    }

    viewModelOf(::ConnectionViewModel)
    viewModelOf(::VideoCallViewModel)
}