package com.hci.obtt.ui.tab.home.bottom_menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.hci.obtt.R
import com.hci.obtt.ui.main.MainActivity

class CustomerServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_service)

        val gotobtn : Button = findViewById<View>(R.id.goto_main_btn2) as Button
        val cs_send_button : Button = findViewById<View>(R.id.cs_send_button) as Button
        val cs_send_text : EditText = findViewById<View>(R.id.cs_send_text) as EditText

        gotobtn.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }

        cs_send_button.setOnClickListener {
            if(cs_send_text.text.toString() == "") {
                cs_send_text.setText("")
                Toast.makeText(this, "문의 내용을 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else {
                cs_send_text.setText("")
                Toast.makeText(this, "보내기 완료", Toast.LENGTH_SHORT).show()
            }
        }
    }
}