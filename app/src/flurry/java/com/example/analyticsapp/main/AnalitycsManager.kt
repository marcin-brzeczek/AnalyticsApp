package com.example.analyticsapp.main

import android.content.Context
import android.util.Log
import com.example.analyticsapp.BuildConfig
import com.flurry.android.FlurryAgent
import com.flurry.android.FlurryPerformance

object AnalitycsManager {

    fun initAnalytics(context: Context) {
        FlurryAgent.Builder()
            .withCaptureUncaughtExceptions(true)
            .withIncludeBackgroundSessionsInMetrics(true)
            .withLogLevel(Log.VERBOSE)
            .withPerformanceMetrics(FlurryPerformance.ALL)
            .build(context, BuildConfig.FLURRY_KEY)
    }

    fun logEvent(eventType:String, map: Map<String, String>) {
        FlurryAgent.logEvent(eventType, map)
    }

    fun logEvent(eventType:String) {
        FlurryAgent.logEvent(eventType)
    }
}