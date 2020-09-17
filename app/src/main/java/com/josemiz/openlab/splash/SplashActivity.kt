package com.josemiz.openlab.splash

import android.content.Intent
import com.josemiz.openlab.R
import com.josemiz.openlab.base.BaseDataBindingActivity
import com.josemiz.openlab.databinding.ActivitySplashBinding
import com.josemiz.openlab.main.MainActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseDataBindingActivity<ActivitySplashBinding>() {
    override fun getLayout(): Int = R.layout.activity_splash

    override fun setup() {
        GlobalScope.launch {
            delay(3000)
            showMainActivity()
        }
    }

    private fun showMainActivity() {
        Intent(this, MainActivity::class.java)
            .also {
                startActivity(it)
            }
        finish()
    }

}