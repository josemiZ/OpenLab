package com.josemiz.openlab.splash

import android.content.Intent
import androidx.constraintlayout.motion.widget.MotionLayout
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
        dataBinding.mlParent.setTransitionListener(object  : MotionLayout.TransitionListener{
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                //Not needed
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                //Not needed
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                showMainActivity()
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
                //Not needed
            }

        })
    }

    private fun showMainActivity() {
        Intent(this, MainActivity::class.java)
            .also {
                startActivity(it)
            }
        finish()
    }

}