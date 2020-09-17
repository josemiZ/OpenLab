package com.josemiz.openlab.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseDataBindingActivity<T : ViewDataBinding> : AppCompatActivity() {
    protected lateinit var dataBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, getLayout())
        dataBinding.lifecycleOwner = this
        setup()
    }

    abstract fun getLayout(): Int
    abstract fun setup()

}