package com.hci.obtt.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.hci.obtt.R
import com.hci.obtt.databinding.ActivitySplashBinding
import com.hci.obtt.ui.BaseActivity
import com.hci.obtt.ui.main.MainActivity
import kotlinx.coroutines.*

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            delay(2000L)

            withContext(Dispatchers.Main) {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)

                startActivity(intent)
                finish()
            }
        }
    }
}
