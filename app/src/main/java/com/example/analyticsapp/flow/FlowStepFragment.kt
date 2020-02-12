package com.example.analyticsapp.flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.analyticsapp.R
import com.example.analyticsapp.main.AnalitycsManager

class FlowStepFragment : Fragment() {


    private var flowStepNumber:Int = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        val safeArgs: FlowStepFragmentArgs by navArgs()
         flowStepNumber = safeArgs.flowStepNumber

        return when (flowStepNumber) {
            2 -> {
                AnalitycsManager.logEvent("OPEN_SCREEN_EVENT", mapOf("OPEN_SCREEN_EVENT" to "STEP_TWO_FRAGMENT"))
                inflater.inflate(R.layout.flow_step_two_fragment, container, false)
            }
            else -> {
                AnalitycsManager.logEvent("OPEN_SCREEN_EVENT", mapOf("OPEN_SCREEN_EVENT" to "STEP_ONE_FRAGMENT"))
                inflater.inflate(R.layout.flow_step_one_fragment, container, false)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.next_button).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.next_action).apply {
                when (flowStepNumber) {
                    2 -> AnalitycsManager.logEvent("CLICK_EVENT", mapOf("CLICK_EVENT" to "CLICK_FINISH_FLOW"))
                    else -> AnalitycsManager.logEvent("CLICK_EVENT", mapOf("CLICK_EVENT" to "CLICK_STEP_TWO"))
                }
            }
        )
    }
}
