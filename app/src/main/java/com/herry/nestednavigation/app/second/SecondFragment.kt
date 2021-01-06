package com.herry.nestednavigation.app.second

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.herry.nestednavigation.R
import com.herry.nestednavigation.databinding.SecondFragmentBinding
import com.herry.nestednavigation.ext.setNavNestedFragmentResultListener

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setNavNestedFragmentResultListener((R.id.second_sub_nav).toString()) { _, bundle ->
            Log.d("Herry", "from = ${bundle.getInt("from")}")
            when(bundle.getInt("from")) {
                R.id.second_sub1_fragment -> {
                    Toast.makeText(requireContext(), "from sub 1", Toast.LENGTH_SHORT).show()
                }
                R.id.second_sub2_fragment -> {
                    viewModel.onClickThirdInSub(binding.root)
//                    Toast.makeText(requireContext(), "from sub 2", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}
