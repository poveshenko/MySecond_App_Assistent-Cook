package com.example.test2.fragments_Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.test2.databinding.FragmentPage1Binding


class FragmentPage1 : Fragment() {


lateinit var binding: FragmentPage1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPage1Binding.inflate(inflater, container, false)
        return binding.root

    }



    }
