package com.herry.nestednavigation.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.herry.nestednavigation.app.second.SecondFragment
import com.herry.nestednavigation.app.second.sub2.SecondSub2Fragment
import com.herry.nestednavigation.R

class MainActivity : AppCompatActivity(), SecondSub2Fragment.OnFragmentListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.main_nav_host_fragment).navigateUp()
    override fun onThird() {
        var currentFragment: Fragment? = null

        val navHostFragment = supportFragmentManager.primaryNavigationFragment

        val list = navHostFragment?.childFragmentManager?.fragments

        if (list?.isNotEmpty() == true) {
            currentFragment = list[0]
        }

        if (currentFragment is SecondFragment) {
            currentFragment.onClickThirdInSub()
        }
    }
}
