package com.example.interview.view.account.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.interview.tools.base.BaseViewModel
import com.example.interview.tools.event.Event
import com.example.interview.tools.extensions.asImmutable
import com.example.interview.tools.service.notification.NotificationService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    override val notificationService: NotificationService
) : BaseViewModel() {

    private val _isLogin = MutableLiveData<Event<Boolean>>().also { false }
    val isLogin = _isLogin.asImmutable()

    fun login(){
        launchWithState {
            _isLogin.value = Event(true)
        }
    }
}