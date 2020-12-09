package com.herry.nestednavigation.app.second.sub2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.herry.nestednavigation.databinding.SecondSub2FragmentBinding


class SecondSub2Fragment : Fragment() {

    interface OnFragmentListener {
        fun onThird()
    }

    private var onFragmentListener: OnFragmentListener? = null

    private var _binding: SecondSub2FragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
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
                onFragmentListener?.onThird()
            }
        }

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentListener) {
            onFragmentListener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        onFragmentListener = null
    }

}
