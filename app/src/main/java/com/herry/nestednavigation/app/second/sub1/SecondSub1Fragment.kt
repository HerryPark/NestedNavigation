package com.herry.nestednavigation.app.second.sub1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.herry.nestednavigation.R
import com.herry.nestednavigation.databinding.SecondSub1FragmentBinding

class SecondSub1Fragment : Fragment() {

    private var _binding: SecondSub1FragmentBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: SecondSub1ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondSub1ViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (_binding == null) {
            _binding = SecondSub1FragmentBinding.inflate(inflater, container, false)

            binding.gotoSecondSub2.setOnClickListener { view ->
                view.findNavController().navigate(R.id.second_sub2_fragment)
            }
        }

        return binding.root
    }
}
