package com.example.interview.view.launcher.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.interview.model.repository.MovieRepository
import com.example.interview.tools.base.BaseViewModel
import com.example.interview.tools.extensions.asImmutable
import com.example.interview.tools.network.NetworkHandler
import com.example.interview.tools.service.notification.NotificationService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LauncherViewModel @Inject constructor(
    override val notificationService: NotificationService,
    private val movieRepository: MovieRepository
) : BaseViewModel() {

    private val _isEmptyMoviesList = MutableLiveData<Boolean>()
    val isEmptyMoviesList: LiveData<Boolean> = _isEmptyMoviesList.asImmutable()

    private val _isNetworkAvailable = MutableLiveData<Boolean>()
    val isNetworkAvailable: LiveData<Boolean> = _isNetworkAvailable.asImmutable()

    fun checkNetworkConnection() {
        if (NetworkHandler.isNetworkAvailable) {
            _isNetworkAvailable.value = true
        } else {
            viewModelScope.launch {
                movieRepository.getMoviesListFromDB()
                _isEmptyMoviesList.value = movieRepository.getMoviesList().isEmpty()
            }
        }
    }
}