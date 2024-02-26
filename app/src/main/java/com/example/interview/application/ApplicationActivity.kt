package com.example.interview.application

import android.os.Bundle
import com.example.interview.databinding.ActivityApplicationBinding
import com.example.interview.tools.base.BaseActivity
import com.example.interview.tools.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ApplicationActivity : BaseActivity<ActivityApplicationBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseViewModel.activityContext = this
        binding = ActivityApplicationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}