/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.ui.fragments.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.steve_md.nftapp.R
import com.steve_md.nftapp.databinding.FragmentIntro2Binding

class IntroFragment2 : Fragment() {

    private lateinit var binding: FragmentIntro2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}