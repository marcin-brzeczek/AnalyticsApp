package com.example.analyticsapp.main

import android.content.Context
import com.example.analyticsapp.BuildConfig
import com.mixpanel.android.mpmetrics.MixpanelAPI
import org.json.JSONObject



object AnalitycsManager {
    fun initAnalytics(context: Context) {
        mixpanel = MixpanelAPI.getInstance(context, BuildConfig.MIXPANEL_KEY);
    }

    fun logEvent(eventType:String, map: Map<String, String>) {
        val props = JSONObject()
        props.put(eventType, map[eventType])
        mixpanel!!.track(eventType, props)
    }

    fun logEvent(eventType:String) {
        mixpanel!!.track(eventType)
    }

    fun flushAnalyticsData() {
        mixpanel!!.flush()
    }
}

private var mixpanel: MixpanelAPI? = null