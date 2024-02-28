package com.example.interview.view.launcher.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.interview.tools.base.BaseViewModel
import com.example.interview.tools.extensions.asImmutable
import com.example.interview.tools.network.NetworkHandler
import com.example.interview.tools.service.notification.NotificationService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NetworkLostViewModel @Inject constructor(
    override val notificationService: NotificationService
) : BaseViewModel() {

    private val _isNetworkAvailable = MutableLiveData<Boolean>()
    val isNetworkAvailable: LiveData<Boolean> = _isNetworkAvailable.asImmutable()

    fun checkNetworkConnection() {
        _isNetworkAvailable.value = NetworkHandler.isNetworkAvailable
    }

    fun showNotification(text: String) {
        notificationService.showInformation(text)
    }
}