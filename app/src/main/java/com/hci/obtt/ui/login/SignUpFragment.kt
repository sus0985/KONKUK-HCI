package com.hci.obtt.ui.login

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.hci.obtt.R
import com.hci.obtt.databinding.FragmentSignUpBinding
import com.hci.obtt.model.User
import com.hci.obtt.ui.base.BaseFragment

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(R.layout.fragment_sign_up) {

    private val viewModel by activityViewModels<LoginViewModel>()
    private var interaction: SignUpInteraction? = null

    interface SignUpInteraction {
        fun changeLogin()
        fun goToMainPage()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SignUpInteraction) {
            interaction = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            textGoLogin.setOnClickListener { interaction?.changeLogin() }
            buttonSignUp.setOnClickListener {

                val id = editTextId.text.toString()
                val pw = editTextPassword.text.toString()

                if (editTextId.text?.isEmpty() != false ||
                    editTextPassword.text?.isEmpty() != false ||
                    editTextConfirmPassword.text?.isEmpty() != false) {
                    showToast(R.string.input_id_password)
                    return@setOnClickListener
                }

                if (viewModel.checkIdExist(editTextId.text?.toString() ?: "")) {
                    showToast(R.string.exist_id)
                    return@setOnClickListener
                }

                if (editTextPassword.text!!.toString() != editTextConfirmPassword.text!!.toString()) {
                    showToast(R.string.check_password)
                    return@setOnClickListener
                }

                interaction?.let { inter ->
                    viewModel.signUp(User(id, pw, inter::goToMainPage))
                }
            }
        }
    }


    companion object {

        fun newInstance() = SignUpFragment()

    }
}