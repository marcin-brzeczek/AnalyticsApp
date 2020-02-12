package com.example.analyticsapp.flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.analyticsapp.R

class FlowStepFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)

        val safeArgs: FlowStepFragmentArgs by navArgs()
        val flowStepNumber = safeArgs.flowStepNumber

        return when (flowStepNumber) {
            2 -> {
                TODO("OPEN_SCREEN_EVENT : STEP_TWO_FRAGMENT")
                TODO("STEP_TWO_FRAGMENT")
                inflater.inflate(R.layout.flow_step_two_fragment, container, false)
            }
            else -> {
                TODO("OPEN_SCREEN_EVENT : STEP_ONE_FRAGMENT")
                TODO("STEP_ONE_FRAGMENT")
                inflater.inflate(R.layout.flow_step_one_fragment, container, false)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.next_button_one_fragment).setOnClickListener{
            TODO("CLICK_EVENT : CLICK_NAVIGATE_NEXT_STEP_BUTTON")
            TODO("CLICK_NAVIGATE_NEXT_STEP_BUTTON")
            Navigation.createNavigateOnClickListener(R.id.next_action)
        }

        view.findViewById<View>(R.id.next_button_one_fragment).setOnClickListener{
            TODO("CLICK_EVENT : CLICK_FINISH_FLOW_BUTTON")
            TODO("CLICK_FINISH_FLOW_BUTTON")
            Navigation.createNavigateOnClickListener(R.id.next_action)
        }
    }
}
