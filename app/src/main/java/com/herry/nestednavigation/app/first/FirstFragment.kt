package com.herry.nestednavigation.app.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.herry.nestednavigation.databinding.FirstFragmentBinding

class FirstFragment : Fragment() {

    private var _binding: FirstFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: FirstViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (_binding == null) {
            _binding = FirstFragmentBinding.inflate(inflater, container, false)

            binding.gotoSecond.setOnClickListener {
                viewModel.onClickSecond(it)
            }
        }

        return binding.root
    }
}
