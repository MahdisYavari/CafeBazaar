package com.example.interview.tools.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textview.MaterialTextView

abstract class BaseFragment<TView : ViewBinding> : Fragment() {

    protected lateinit var binding: TView

    protected fun goToNextPage(nextPageId: Int, bundle: Bundle ?= null) {
        view?.let { Navigation.findNavController(it).navigate(nextPageId, bundle) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createDialog()
        initObserver()
        initListener()
    }

    private fun createDialog() {

    }

    fun setToolbar(toolbar: MaterialToolbar, description: String, isSetBackPress: Boolean = true) {
        val appActivity = requireActivity() as AppCompatActivity?
        appActivity?.setSupportActionBar(toolbar)
        //add back icon in action bar
        appActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(isSetBackPress)
        //add title in action bar
        appActivity?.supportActionBar?.title = description
        //add sub title in action bar
//        myActivity?.supportActionBar?.subtitle = if (it.subTitle == it.title) null else it.subTitle
    }

    fun setToolbar(
        toolbar: MaterialToolbar,
        description: String,
        txtDescription: MaterialTextView
    ) {
        val appActivity = activity as AppCompatActivity?
        appActivity?.setSupportActionBar(toolbar)
        //add back icon in action bar
//        appActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        txtDescription.text = description
    }

    protected open fun initListener(){

    }

    protected open fun initObserver(){

    }
}