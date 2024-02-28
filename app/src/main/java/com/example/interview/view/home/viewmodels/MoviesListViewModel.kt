package com.example.interview.view.home.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.interview.model.MovieResultItemModel
import com.example.interview.model.repository.MovieRepository
import com.example.interview.tools.base.BaseViewModel
import com.example.interview.tools.extensions.asImmutable
import com.example.interview.tools.service.notification.NotificationService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    override val notificationService: NotificationService,
    private val movieRepository: MovieRepository
) : BaseViewModel() {

    private val _movieList= MutableLiveData<List<MovieResultItemModel>>()
    val movieList: LiveData<List<MovieResultItemModel>> = _movieList.asImmutable()


    fun getMovieList() {
        launchWithState {
            movieRepository.getMovieResponse()
            _movieList.value = movieRepository.getMoviesListFromServer()
        }
    }

    override fun handleUnavailableNetwork() {
        super.handleUnavailableNetwork()
        launchWithState {
            movieRepository.getMoviesListFromDB()
            _movieList.value = movieRepository.getMoviesList()
        }
    }

    fun showNotification(text: String) {
        notificationService.showInformation(text)
    }

    fun addMoviesListInDB() {
        launchWithState {
            movieRepository.addMoviesListInDB()
        }
    }
}