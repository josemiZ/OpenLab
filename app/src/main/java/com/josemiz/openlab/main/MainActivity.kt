package com.josemiz.openlab.main

import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.josemiz.openlab.R
import com.josemiz.openlab.base.BaseDataBindingActivity
import com.josemiz.openlab.databinding.ActivityMainBinding

class MainActivity : BaseDataBindingActivity<ActivityMainBinding>() {
    override fun getLayout(): Int = R.layout.activity_main

    override fun setup() {
        Navigation.findNavController(this, R.id.navigation_host).also {
            NavigationUI.setupWithNavController(dataBinding.bottomNavigation, it)
        }
    }

}