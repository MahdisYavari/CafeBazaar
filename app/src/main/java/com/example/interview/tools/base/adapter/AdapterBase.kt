package com.example.interview.tools.base.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.interview.tools.base.BaseViewModel

/*
    ability:
        1. update list
        2. remove row
 */
abstract class AdapterBase<
        TView : ViewBinding,
        TModel,
        TViewHolder : AdapterBase<TView, TModel, TViewHolder>.ViewHolderBase<TView>
        >(
    var list: List<TModel>
) : RecyclerView.Adapter<TViewHolder>() {

    protected val context = BaseViewModel.activityContext

    override fun onBindViewHolder(holder: TViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    open fun removeItem(position: Int) {
        notifyItemRemoved(position)
    }

    open fun restoreItem(position: Int) {
        notifyItemInserted(position)
    }

    open fun restoreItem(position: Int, model: TModel) {
        notifyItemInserted(position)
    }

    open fun update(newList: List<TModel>) {
        val diffResult = DiffUtil.calculateDiff(diffCallback(newList))
        list = newList
        diffResult.dispatchUpdatesTo(this)
    }

    open fun update() {
        //todo update with id
        notifyDataSetChanged()
    }

    abstract fun diffCallback(newList: List<TModel>): DiffUtil.Callback

    abstract inner class ViewHolderBase<TView : ViewBinding>(protected val binding: TView) :
        RecyclerView.ViewHolder(binding.root) {

        open fun bind(model: TModel) {
            initListener(model)
        }

        protected open fun initListener(model: TModel) {

        }
    }
}