package com.hci.obtt.ui.tab.home.bottom_menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.hci.obtt.R
import com.hci.obtt.ui.main.MainActivity

class RecommendedByAgeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommended_by_age)

        val pagerAdapter = AgeFragmentAdapter(supportFragmentManager)
        val pager = findViewById<ViewPager>(R.id.RBViewPager)
        pager.adapter = pagerAdapter
        val tab = findViewById<TabLayout>(R.id.tab)
        tab.setupWithViewPager(pager)

        val gotobtn : Button = findViewById<View>(R.id.goto_main_btn3) as Button

        gotobtn.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }
    }
}