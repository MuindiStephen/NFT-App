/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.ui.fragments.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.steve_md.nftapp.R
import com.steve_md.nftapp.databinding.FragmentIntro2Binding

class IntroFragment2 : Fragment() {

    private lateinit var binding: FragmentIntro2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentIntro2Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpBinding()
    }

    private fun setUpBinding() {
        binding.continueButton.setOnClickListener {
            findNavController().navigate(R.id.action_introFragment2_to_homeFragment)
        }

    }

}