package com.example.analyticsapp

import android.app.Application
import com.example.analyticsapp.main.AnalitycsManager

class AnalyticsApp : Application(){

    override fun onCreate() {
        super.onCreate()
        AnalitycsManager.initAnalytics(this)
    }
}