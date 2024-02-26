package com.example.interview.tools.service.notification

interface NotificationService {
    fun showInformation(text: String)
    fun showError(text: String)
    fun showLongInformation(text: String)
}