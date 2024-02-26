package com.example.interview.tools.base

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.example.interview.tools.network.ExceptionHandler
import com.example.interview.tools.network.NetworkHandler
import com.example.interview.tools.service.notification.NotificationService
import kotlinx.coroutines.launch

abstract class BaseViewModel(
) : ViewModel() {
    protected abstract val notificationService: NotificationService

    fun launchWithState(action: suspend () -> Unit) =
        performLaunchWithState(
            false,
            true,
            action,
            {}, {})

    fun launchWithState(
        isPerformFinallyActionWithSuccessResponseState: Boolean = false,
        isSendFailedNotification: Boolean = true,
        action: suspend () -> Unit,
        failedAction: suspend () -> Unit = {},
        finallyAction: () -> Unit = {}
    ) = performLaunchWithState(
        isPerformFinallyActionWithSuccessResponseState,
        isSendFailedNotification,
        action,
        failedAction,
        finallyAction
    )

    private fun performLaunchWithState(
        isPerformFinallyActionWithSuccessResponseState: Boolean,
        isSendFailedNotification: Boolean,
        action: suspend () -> Unit,
        failedAction: suspend () -> Unit,
        finallyAction: () -> Unit
    ) {
        when (NetworkHandler.isNetworkAvailable) {
            true -> {
                viewModelScope.launch {
                    var isSuccess = false
                    if (_isNotBusy.value != false) {
                        try {
                            _isNotBusy.value = false
                            action()
                            isSuccess = true
                        } catch (exc: Exception) {
                            if (isSendFailedNotification) {
                                notificationService.showError(ExceptionHandler.getErrorMessage(exc))
                            }
                            failedAction()
                        } finally {
                            _isNotBusy.value = true
                            when (isPerformFinallyActionWithSuccessResponseState) {
                                true -> if (isSuccess) finallyAction()
                                false -> finallyAction()
                            }
                        }
                    }
                }
            }
            false -> {
                //todo
//                ApplicationActivity.networkDialog?.dialog?.show()
            }
        }
    }

    protected fun sendInformationMessage(messageId: Int) {
        notificationService.showInformation(
            activityContext.getString(
                messageId
            )
        )
    }

    protected fun sendErrorMessage(messageId: Int) {
        notificationService.showError(
            activityContext.getString(
                messageId
            )
        )
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var activityContext: AppCompatActivity
        private val _isNotBusy = MutableLiveData(true)
        fun isNotBusy(): Boolean = _isNotBusy.value ?: true
    }
}