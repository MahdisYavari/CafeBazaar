package com.example.interview.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.interview.databinding.FragmentMoviesListBinding
import com.example.interview.model.MovieResultItemModel
import com.example.interview.tools.base.BaseFragment
import com.example.interview.view.home.adapter.MovieAdapter
import com.example.interview.view.home.viewmodels.MoviesListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesListFragment: BaseFragment<FragmentMoviesListBinding>(), MovieAdapter.SelectItem {


    private val viewModel by viewModels<MoviesListViewModel>()
    private var movieAdapter: MovieAdapter?= null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesListBinding.inflate(layoutInflater)
        setToolbar(
            binding.includeToolbar.toolbar,
            "Discover",
            binding.includeToolbar.tvDescription
        )
        viewModel.getMovieList()
        return binding.root
    }

    override fun initObserver() {
        super.initObserver()
        viewModel.movieList.observe(viewLifecycleOwner) {
            setUpRecyclerview(it)
        }
    }

    private fun setUpRecyclerview(movieList: List<MovieResultItemModel>) {
        binding.rvMovies.layoutManager =
            GridLayoutManager(
                requireActivity(),
                3,
                LinearLayoutManager.VERTICAL,
                false
            )
        movieAdapter = MovieAdapter(
            movieList,
            this
        )
        binding.rvMovies.adapter = movieAdapter
    }

    override fun selectProduct(movieTitle: String) {
        viewModel.showNotification(movieTitle)
    }
}