package com.hci.obtt.ui.login

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.hci.obtt.R
import com.hci.obtt.databinding.FragmentLoginBinding
import com.hci.obtt.ui.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    private val viewModel by activityViewModels<LoginViewModel>()
    private var interaction: LoginInteraction? = null

    interface LoginInteraction {
        fun goToMainPage()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is LoginInteraction) {
            interaction = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.buttonLogin.setOnClickListener {
            if (viewModel.isIdAndPasswordNotEmpty()) {
                viewModel.checkUserInfo()
            } else {
                showToast(R.string.input_id_password)
            }
        }

    }


    companion object {

        fun newInstance() = LoginFragment()

    }
}
