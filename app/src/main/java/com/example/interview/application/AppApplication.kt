package com.example.interview.application

import android.app.Application
import com.example.interview.tools.service.notification.NotificationServiceImp
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@HiltAndroidApp
class AppApplication : Application() {

    override fun onCreate() {
        try {
            super.onCreate()
            context = this
            NotificationServiceImp.androidApplication = this
        } catch (e: Exception) {
        }
    }

    companion object {
        lateinit var context: AppApplication
    }
}