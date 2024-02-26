package com.example.interview.tools.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.interview.R
import com.example.interview.tools.service.notification.NotificationService

abstract class BaseActivity<TView : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: TView

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        BaseViewModel.activityContext = this
    }

    override fun onBackPressed() {
        if (BaseViewModel.isNotBusy()) {
            super.onBackPressed()
        } else {
        }
    }
}