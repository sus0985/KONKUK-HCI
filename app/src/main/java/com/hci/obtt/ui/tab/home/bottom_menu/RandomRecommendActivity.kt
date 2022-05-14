package com.hci.obtt.ui.tab.home.bottom_menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ViewFlipper
import com.hci.obtt.R
import com.hci.obtt.ui.main.MainActivity
import kotlin.concurrent.timer
import kotlin.random.Random

class RandomRecommendActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_recommend)

        val gotobtn : Button = findViewById<View>(R.id.goto_main_btn1) as Button
        val btnStart : Button = findViewById<View>(R.id.RandomRecommend_btnStart) as Button
        val vf : ViewFlipper = findViewById<View>(R.id.RandomRecommend_vf) as ViewFlipper
        var x = 1

        vf.flipInterval = 200

        gotobtn.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }

        btnStart.setOnClickListener {
            vf.startFlipping()

            timer(period = 2000) {
                if(x == 0) {
                    cancel()
                    vf.stopFlipping()
                }
                x--
            }
        }
    }
}