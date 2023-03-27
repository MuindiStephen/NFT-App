/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.ui.fragments.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.steve_md.nftapp.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSplashBinding.inflate(
            inflater,
            container,
            false
        )
         return binding.root
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            hideActionBar()
        }
        private fun hideActionBar() {
                (activity as AppCompatActivity).actionBar?.hide()
        }

   }




}