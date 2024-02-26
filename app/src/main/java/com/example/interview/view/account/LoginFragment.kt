package com.example.interview.view.account

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import com.example.interview.R
import com.example.interview.databinding.FragmentLoginBinding
import com.example.interview.tools.base.BaseFragment
import com.example.interview.view.account.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initObserver() {
        super.initObserver()
        viewModel.isLogin.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { // Only proceed if the event has never been handled
                goToNextPage(R.id.action_login_to_home)
            }
        }
    }

    override fun initListener() {
        super.initListener()
        binding.btnOk.setOnClickListener {
            viewModel.login()
        }
    }
}