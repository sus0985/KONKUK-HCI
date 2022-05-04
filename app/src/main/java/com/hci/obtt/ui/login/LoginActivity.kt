package com.hci.obtt.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.IntDef
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.hci.obtt.R
import com.hci.obtt.databinding.ActivityLoginBinding
import com.hci.obtt.ui.BaseActivity
import com.hci.obtt.ui.main.MainActivity
import kotlinx.coroutines.flow.collect

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login), LoginFragment.LoginInteraction {

    private val viewModel by viewModels<LoginViewModel>()
    private val viewPagerAdapter by lazy { ViewPagerAdapter(this, titles) }
    private val titles by lazy {
        arrayOf(
            getString(R.string.login),
            getString(R.string.sign_up)
        )
    }

    init {
        lifecycleScope.launchWhenStarted {
            viewModel.userFlow.collect(::onUserInfoCheckCollected)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }

    private fun onUserInfoCheckCollected(isCorrect: Boolean) {
        Log.d(TAG, "onUserInfoCheckCollected() called with: isCorrect = [$isCorrect]")
        if (isCorrect) goToMainPage()
        else showToast(R.string.wrong_id_password)
    }

    override fun goToMainPage() {
        val intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
        finish()
    }


    private class ViewPagerAdapter(
        activity: BaseActivity<ActivityLoginBinding>,
        private val titles: Array<String>
    ) : FragmentStateAdapter(activity) {

        override fun getItemCount(): Int = titles.size

        override fun createFragment(@LoginTab position: Int): Fragment {
            val fragment: Fragment = when (position) {
                TAB_LOGIN -> LoginFragment.newInstance()
                TAB_SIGN_UP -> SignUpFragment.newInstance()
                else -> throw IllegalStateException("Unknown tab")
            }

            return fragment
        }


        companion object {
            const val TAB_LOGIN = 0
            const val TAB_SIGN_UP = 1

            @IntDef(TAB_LOGIN, TAB_SIGN_UP)
            @Retention(AnnotationRetention.SOURCE)
            annotation class LoginTab
        }
    }


    companion object {

        private const val TAG = "LoginActivity"

    }
}