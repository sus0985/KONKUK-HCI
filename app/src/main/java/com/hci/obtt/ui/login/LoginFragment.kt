package com.hci.obtt.ui.login

import android.os.Bundle
import android.view.View
import com.hci.obtt.R
import com.hci.obtt.databinding.FragmentLoginBinding
import com.hci.obtt.ui.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLogin.setOnClickListener {

        }
    }

    companion object {

        fun newInstance() = LoginFragment()

    }
}
