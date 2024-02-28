package com.example.interview.application

import android.os.Bundle
import android.view.View
import com.example.interview.databinding.ActivityApplicationBinding
import com.example.interview.tools.base.BaseActivity
import com.example.interview.tools.base.BaseViewModel
import com.example.interview.tools.network.NetworkHandler
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ApplicationActivity : BaseActivity<ActivityApplicationBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseViewModel.activityContext = this
        binding = ActivityApplicationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun initObservers() {
        super.initObservers()
        BaseViewModel.isNotBusy.observe(this) {
            it?.let {
                when (it) {
                    true -> binding.progressApp.visibility = View.GONE
                    false -> binding.progressApp.visibility = View.VISIBLE
                }
            }
        }
    }
}