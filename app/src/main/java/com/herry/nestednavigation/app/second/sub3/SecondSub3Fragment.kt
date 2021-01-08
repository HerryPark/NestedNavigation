package com.herry.nestednavigation.app.second.sub3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.herry.nestednavigation.R
import com.herry.nestednavigation.databinding.SecondSub3FragmentBinding


class SecondSub3Fragment : Fragment() {

    private var _binding: SecondSub3FragmentBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: SecondSub3ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondSub3ViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (_binding == null) {
            _binding = SecondSub3FragmentBinding.inflate(inflater, container, false)

            binding.clearTopToSub1.setOnClickListener { view ->
                // clear top
                val navOptions = NavOptions.Builder()
                    .setPopUpTo(R.id.second_sub1_fragment, false)
                    .build()

                view.findNavController().navigate(R.id.second_sub1_fragment, null, navOptions)
            }
            binding.popupToSub1.setOnClickListener { view ->
                view.findNavController().navigate(SecondSub3FragmentDirections.secondSub3ToSub1())
            }
        }

        return binding.root
    }
}