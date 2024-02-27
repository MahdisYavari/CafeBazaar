package com.example.interview.view.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.interview.databinding.MoviesListItemBinding
import com.example.interview.model.MovieResultItemModel
import com.example.interview.tools.base.adapter.AdapterBase
import com.squareup.picasso.Picasso

class MovieAdapter(
    moviesList: List<MovieResultItemModel>,
    val selectItem: SelectItem
) : AdapterBase<MoviesListItemBinding, MovieResultItemModel, MovieAdapter.HomeHolder>(moviesList) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        return HomeHolder(
            MoviesListItemBinding.inflate(
                LayoutInflater.from(context),
                parent, false
            )
        )
    }

    inner class HomeHolder(binding: MoviesListItemBinding) :
        ViewHolderBase<MoviesListItemBinding>(binding) {

        @SuppressLint("SetTextI18n")
        override fun bind(movieResultItemModel: MovieResultItemModel) {
            super.bind(movieResultItemModel)
            binding.txtMovieName.text = movieResultItemModel.title
            Picasso.get().load("https://image.tmdb.org/t/p/w500" + movieResultItemModel.posterPath)
                .into(binding.imgMovie)
        }

        override fun initListener(movieResultItemModel: MovieResultItemModel) {
            super.initListener(movieResultItemModel)
            binding.root.setOnClickListener {
                selectItem.selectProduct(movieResultItemModel.originalTitle ?: "")
            }
        }

    }

    interface SelectItem {
        fun selectProduct(movieTitle: String)
    }

    override fun diffCallback(newList: List<MovieResultItemModel>) =
        MovieDiffCallback(list, newList)
}