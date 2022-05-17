package com.hci.obtt.ui.tab.home.bottom_menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.hci.obtt.R
import com.hci.obtt.ui.main.MainActivity

class ShareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        val gotobtn : Button = findViewById<View>(R.id.goto_main_btn4) as Button

        gotobtn.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }
    }
}