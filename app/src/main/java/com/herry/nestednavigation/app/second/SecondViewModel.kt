package com.herry.nestednavigation.app.second

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.herry.nestednavigation.R

class SecondViewModel : ViewModel() {

    var showSub: MutableLiveData<Boolean> = MutableLiveData(false)

    fun onClickThird(v: View) {
        v.findNavController().navigate(R.id.action_second_fragment_to_third_fragment)
    }

    fun onClickShowSub(v: View) {
        showSub.value = showSub.value != true
    }

    fun onClickThirdInSub(v: View) {
        v.findNavController().navigate(R.id.action_second_fragment_to_third_fragment)
    }
}
