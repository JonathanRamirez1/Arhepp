package com.ramiguev.arhepp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ramiguev.arhepp.databinding.FragmentExplorerBinding

class ExplorerFragment : Fragment() {

    private lateinit var binding: FragmentExplorerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentExplorerBinding.inflate(inflater, container, false)
        return binding.root
    }
}