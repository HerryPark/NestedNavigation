package com.herry.nestednavigation.app.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.herry.nestednavigation.databinding.SecondFragmentBinding

class SecondFragment : Fragment() {

    private var _binding: SecondFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: SecondViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        viewModel.showSub.observe(this, { visible ->
            binding.secondSubNavHostFragment.visibility = if (visible) View.VISIBLE else View.GONE
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (_binding == null) {
            _binding = SecondFragmentBinding.inflate(inflater, container, false)

            binding.gotoThird.setOnClickListener {
                viewModel.onClickThird(it)
            }

            binding.showSubScreen.setOnClickListener {
                viewModel.onClickShowSub(it)
            }
        }

        return binding.root
    }

    fun onClickThirdInSub() {
        viewModel.onClickThirdInSub(binding.root)
    }
}
