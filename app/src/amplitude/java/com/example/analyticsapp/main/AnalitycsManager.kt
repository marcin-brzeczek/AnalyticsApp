package com.example.analyticsapp.main

import android.app.Application
import com.amplitude.api.Amplitude
import com.example.analyticsapp.BuildConfig
import org.json.JSONObject

object AnalitycsManager {

    fun initAnalytics(application: Application) {
        Amplitude.getInstance().initialize(
            application,
            BuildConfig.AMPLITUDE_KEY
        ).enableForegroundTracking(application)
    }

    fun logEvent(eventType:String, map: Map<String, String>) {
        Amplitude.getInstance().logEvent(eventType, JSONObject(map))
    }

    fun logEvent(eventType: String) {
        Amplitude.getInstance().logEvent(eventType)
    }
}