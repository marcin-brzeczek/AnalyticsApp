package com.example.analyticsapp.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.analyticsapp.R
import com.example.analyticsapp.main.AnalitycsManager

class SettingsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.settings_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnalitycsManager.logEvent("OPEN_SCREEN_EVENT", mapOf("OPEN_SCREEN_EVENT" to "SETTINGS_FRAGMENT"))
    }
}


