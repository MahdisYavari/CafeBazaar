package com.example.interview.tools.network

import com.example.interview.R
import com.example.interview.tools.base.BaseViewModel
import retrofit2.HttpException

object ExceptionHandler {

    private val context = BaseViewModel.activityContext

    fun getErrorMessage(exc: Exception): String {
        return try {
            val httpException: HttpException = exc as HttpException
            val errorBody: String = httpException.response()?.errorBody()?.string()!!
            handleMessage(errorBody)
        } catch (e: Exception) {
            getMessage(R.string.action_failed)
        }
    }

    private fun handleMessage(errorBody: String): String {
        return when {
            errorBody.contains("Unexpected╪ Error!\",\"Object reference not set to an instance of an object.")
            -> getMessage(R.string.action_failed)
            else -> {
                getMessage(R.string.action_failed)
            }
        }
    }

    private fun getMessage(messageId: Int) = context.getString(messageId)
}