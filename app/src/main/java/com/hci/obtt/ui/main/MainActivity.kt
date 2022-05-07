package com.hci.obtt.ui.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hci.obtt.R
import com.hci.obtt.databinding.ActivityMainBinding
import com.hci.obtt.ui.base.BaseActivity

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
}
