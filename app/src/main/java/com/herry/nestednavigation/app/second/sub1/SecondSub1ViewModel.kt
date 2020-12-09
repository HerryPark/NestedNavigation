package com.herry.nestednavigation.app.second.sub1

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.herry.nestednavigation.R

class SecondSub1ViewModel : ViewModel() {

    fun onStep2Click(v: View) {
        v.findNavController().navigate(R.id.second_sub2_fragment)
    }
}
