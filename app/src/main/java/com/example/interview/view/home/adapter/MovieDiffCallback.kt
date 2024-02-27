package com.example.interview.view.home.adapter

import com.example.interview.model.MovieResultItemModel
import com.example.interview.tools.base.adapter.BaseDiffCallback

class MovieDiffCallback(
    oldList: List<MovieResultItemModel>,
    newList: List<MovieResultItemModel>
) : BaseDiffCallback<MovieResultItemModel>(
    oldList, newList
) {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    /*this method will be called to check whether old and new items represent the same item visually.
     This will only be called when areItemsTheSame() returns true.*/
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }
}