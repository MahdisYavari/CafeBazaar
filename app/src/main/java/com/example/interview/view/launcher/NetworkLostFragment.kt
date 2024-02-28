package com.example.interview.view.launcher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.interview.R
import com.example.interview.databinding.FragmentNetworkLostBinding
import com.example.interview.tools.base.BaseFragment
import com.example.interview.view.launcher.viewmodels.NetworkLostViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NetworkLostFragment : BaseFragment<FragmentNetworkLostBinding>() {

    private val viewModel by viewModels<NetworkLostViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNetworkLostBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initObserver() {
        super.initObserver()
        viewModel.isNetworkAvailable.observe(viewLifecycleOwner) {
            if (it == true) {
                goToNextPage(R.id.action_network_lost_to_home)
            } else {
                viewModel.showNotification(getString(R.string.network_error))
            }
        }
    }

    override fun initListener() {
        super.initListener()
        binding.btnRetry.setOnClickListener {
            viewModel.checkNetworkConnection()
        }
    }
}