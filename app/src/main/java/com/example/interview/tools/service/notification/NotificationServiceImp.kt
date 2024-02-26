package com.example.interview.tools.service.notification

import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class NotificationServiceImp @Inject constructor() : NotificationService {

    override fun showInformation(text: String) {
        Toast.makeText(androidApplication, text, Toast.LENGTH_SHORT).show()
    }

    override fun showError(text: String) {
        showInformation(text)
    }

    override fun showLongInformation(text: String) {
        Toast.makeText(androidApplication, text, Toast.LENGTH_LONG).show()
    }

    companion object {
        lateinit var androidApplication: Context
    }
}