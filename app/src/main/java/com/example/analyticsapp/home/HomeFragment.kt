package com.example.analyticsapp.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.navigation.ui.onNavDestinationSelected
import com.example.analyticsapp.R
import com.example.analyticsapp.main.AnalitycsManager
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    private val navigationOptions by lazy { navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
      }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()

        AnalitycsManager.logEvent("OPEN_SCREEN_EVENT", mapOf("OPEN_SCREEN_EVENT" to "HOME_FRAGMENT"))

    }

    private fun setListeners() {
        navigate_destination_button.setOnClickListener {
            AnalitycsManager.logEvent("CLICK_EVENT", mapOf("CLICK_EVENT" to "CLICK_START_BUTTON"))
            findNavController().navigate(R.id.flow_step_one_dest, null, navigationOptions)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        AnalitycsManager.logEvent("CLICK_EVENT", mapOf("CLICK_EVENT" to "CLICK_CART"))
      
        return  item.onNavDestinationSelected(findNavController())  ||  return super.onOptionsItemSelected(item)
    }
}