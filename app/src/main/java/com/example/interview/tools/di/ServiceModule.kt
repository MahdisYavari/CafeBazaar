package com.example.interview.tools.di

import com.example.interview.tools.service.notification.NotificationService
import com.example.interview.tools.service.notification.NotificationServiceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun bindNotificationService(): NotificationService {
        return NotificationServiceImp()
    }
}