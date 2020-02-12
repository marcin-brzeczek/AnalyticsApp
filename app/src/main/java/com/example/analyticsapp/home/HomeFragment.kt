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
        //todo "OPEN_SCREEN_EVENT : HOME_FRAGMENT"
//        TODO("OPEN_SCREEN_EVENT : HOME_FRAGMENT")
//        TODO("OPEN_HOME_FRAGMENT")
    }

    private fun setListeners() {
        navigate_destination_button.setOnClickListener {
            //todo "CLICK_EVENT : CLICK_START_BUTTON")
            //todo "CLICK_START_BUTTON")
            AnalitycsManager.logEvent("START BUTTON")
            findNavController().navigate(R.id.flow_step_one_dest, null, navigationOptions)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //todo "CLICK_EVENT: CLICK_CART")
        //todo "CLICK_CART")

       return  item.onNavDestinationSelected(findNavController())  ||  return super.onOptionsItemSelected(item)
    }
}