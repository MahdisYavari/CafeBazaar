package com.example.interview.view.launcher

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.interview.R
import com.example.interview.databinding.FragmentLauncherBinding
import com.example.interview.tools.base.BaseFragment
import com.example.interview.view.launcher.viewmodels.LauncherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LauncherFragment : BaseFragment<FragmentLauncherBinding>() {

    private val viewModel by viewModels<LauncherViewModel>()
    private val handler = Handler()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLauncherBinding.inflate(layoutInflater)
        viewModel.checkNetworkConnection()
        return binding.root
    }

    override fun initObserver() {
        super.initObserver()
        viewModel.isNetworkAvailable.observe(viewLifecycleOwner) {
            if (it == true) {
                handler.postDelayed({
                    goToNextPage(R.id.action_launcher_to_home)
                }, 3000)
            }
        }
        viewModel.isEmptyMoviesList.observe(viewLifecycleOwner) { isEmpty ->
            if (isEmpty == true) {
                handler.postDelayed({
                    goToNextPage(R.id.action_launcher_to_network_lost)
                }, 3000)
            } else {
                handler.postDelayed({
                    goToNextPage(R.id.action_launcher_to_home)
                }, 3000)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacksAndMessages(null)
    }
}