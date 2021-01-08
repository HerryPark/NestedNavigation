package com.herry.nestednavigation.app.second

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.herry.nestednavigation.R
import com.herry.nestednavigation.databinding.SecondFragmentBinding
import com.herry.nestednavigation.ext.findNestedNavHostFragment
import com.herry.nestednavigation.ext.setNestedNavHostFragmentResultListener

class SecondFragment : Fragment() {

    private var _binding: SecondFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: SecondViewModel

    private var subNavHostFragment: NavHostFragment? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (_binding == null) {
            _binding = SecondFragmentBinding.inflate(inflater, container, false)

            val subNavHost = findNestedNavHostFragment(binding.secondFragmentSubContainer.id)
            if (subNavHost != null) {
                subNavHostFragment = subNavHost
                setNestedNavHostFragmentResultListener(subNavHost) { _, bundle ->
                    onSubScreenResults(bundle)
                }
            }

            binding.secondFragmentBottomShowSub3.setOnClickListener {
                subNavHostFragment?.navController?.navigate(R.id.second_sub3_fragment)
            }
        }

        return binding.root
    }

    private fun onSubScreenResults(bundle: Bundle) {
        Log.d("Herry", "from = ${bundle.getInt("from")}")
        when (bundle.getInt("from")) {
            R.id.second_sub1_fragment -> {
                Toast.makeText(requireContext(), "from sub 1", Toast.LENGTH_SHORT).show()
            }
            R.id.second_sub2_fragment -> {
                findNavController().navigate(R.id.action_second_fragment_to_third_fragment)
                Toast.makeText(requireContext(), "from sub 2", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
