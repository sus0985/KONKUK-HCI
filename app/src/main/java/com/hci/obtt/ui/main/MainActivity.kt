package com.hci.obtt.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hci.obtt.R
import com.hci.obtt.databinding.ActivityMainBinding
import com.hci.obtt.ui.VideoDetailActivity
import com.hci.obtt.ui.base.BaseActivity
import com.hci.obtt.ui.tab.home.bottom_menu.CustomerServiceActivity
import com.hci.obtt.ui.tab.home.bottom_menu.RandomRecommendActivity
import com.hci.obtt.ui.tab.home.bottom_menu.RecommendedByAgeActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHost = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment

        navController = navHost.findNavController()
        binding.bottomNavigation.apply {
            setupWithNavController(navController)
            itemIconTintList = null
        }
    }

    fun goToVideoDetail() {
        startActivity(Intent(this, VideoDetailActivity::class.java))
    }

    fun goToRandomRecommend() {
        startActivity(Intent(this, RandomRecommendActivity::class.java))
    }

    fun goToRecommendedByAge() {
        startActivity(Intent(this, RecommendedByAgeActivity::class.java))
    }

    fun goToCustomerService() {
        startActivity(Intent(this, CustomerServiceActivity::class.java))
    }
}
