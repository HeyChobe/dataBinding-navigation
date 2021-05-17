package com.example.labo1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.labo1.FormViewModel
import com.example.labo1.databinding.ControlFragmentBinding

class ControlFragment: Fragment() {

    private var _binding : ControlFragmentBinding? = null
    private val binding get() = _binding!!
    private val formViewModel : FormViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ControlFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = formViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

}