package com.ramiguev.arhepp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ramiguev.arhepp.R
import com.ramiguev.arhepp.databinding.FragmentRecordingBinding

class RecordingFragment : Fragment() {

    private lateinit var binding: FragmentRecordingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRecordingBinding.inflate(inflater, container, false)
        return binding.root
    }
}