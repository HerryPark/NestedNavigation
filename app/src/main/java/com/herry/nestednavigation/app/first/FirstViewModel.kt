package com.herry.nestednavigation.app.first

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.herry.nestednavigation.R

class FirstViewModel : ViewModel() {

    fun onClickSecond(v: View) {
        v.findNavController().navigate(R.id.action_first_fragment_to_second_fragment)
    }
}
