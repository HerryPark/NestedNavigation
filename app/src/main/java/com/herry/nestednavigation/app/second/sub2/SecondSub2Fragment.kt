package com.herry.nestednavigation.app.second.sub2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.herry.nestednavigation.databinding.SecondSub2FragmentBinding
import com.herry.nestednavigation.ext.getNavCurrentDestinationID
import com.herry.nestednavigation.ext.getNavGraphID
import com.herry.nestednavigation.ext.setNavNestedFragmentResult


class SecondSub2Fragment : Fragment() {

    private var _binding: SecondSub2FragmentBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: SecondSub2ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondSub2ViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (_binding == null) {
            _binding = SecondSub2FragmentBinding.inflate(inflater, container, false)

            binding.gotoThirdInSub.setOnClickListener {
                setNavNestedFragmentResult(
                    (getNavGraphID()).toString(), bundleOf(
                        "from" to getNavCurrentDestinationID(),
                        "value" to "clicked"
                    )
                )
            }
        }

        return binding.root
    }
}
