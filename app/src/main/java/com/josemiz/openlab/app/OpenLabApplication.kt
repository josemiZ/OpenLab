package com.josemiz.openlab.app

import android.app.Application

class OpenLabApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initDI()
    }
}