package com.hci.obtt.ui.tab.home.bottom_menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import com.hci.obtt.R

class ShareActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share2)

        val gotobtn : Button = findViewById<View>(R.id.goto_main_btn5) as Button
        val uploadbtn : Button = findViewById<View>(R.id.btn6) as Button

        gotobtn.setOnClickListener {
            val intent = Intent(this, ShareActivity::class.java)
            startActivity(intent)
        }

        var ottchoice : TextView = findViewById<View>(R.id.ottpassname) as TextView
        var sharingText : String = findViewById<View>(R.id.TextMultiLine).toString()

        var radiogroup : RadioGroup = findViewById<View>(R.id.RadioGroup10) as RadioGroup

        uploadbtn.setOnClickListener {
            when(radiogroup.checkedRadioButtonId) {
                R.id.Radio_nexflix -> ottchoice.text = "Netflix"
                R.id.Radio_watcha -> ottchoice.text = "Watcha"
                R.id.Radio_disney -> ottchoice.text = "Disney+"
                R.id.Radio_tving -> ottchoice.text = "Tving"
                R.id.Radio_wavve -> ottchoice.text = "Wavve"
                R.id.Radio_appletv -> ottchoice.text = "Appletv+"
            }

            var intent2 = Intent(this, ShareActivity::class.java)
            intent2.putExtra("ottnamekey", ottchoice.text)
            intent2.putExtra("textmulti", sharingText)
            startActivity(intent2)
        }
    }
}