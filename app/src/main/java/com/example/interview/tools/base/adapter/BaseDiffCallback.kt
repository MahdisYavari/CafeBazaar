package com.example.interview.tools.base.adapter

import androidx.recyclerview.widget.DiffUtil

abstract class BaseDiffCallback<TModel>(
    protected val oldList: List<TModel>,
    protected val newList: List<TModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }
}