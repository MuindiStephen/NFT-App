/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.ui.fragments.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.steve_md.nftapp.R
import com.steve_md.nftapp.data.NftData
import com.steve_md.nftapp.databinding.FragmentHomeBinding
import com.steve_md.nftapp.network.Resource
import com.steve_md.nftapp.ui.recyclerview.NftMultipleViewAdapter
import com.steve_md.nftapp.ui.viewmodel.NFTViewModel
import com.steve_md.nftapp.utils.ExtensionFunctions.changeVisibility
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val nftMultipleViewAdapter by lazy { NftMultipleViewAdapter() }
    private val nftViewModel: NFTViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(
            inflater,container,false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.nftRecyclerView.apply {
            val gridLayoutManager = GridLayoutManager(requireActivity(), 2)
            gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (nftMultipleViewAdapter.getItemViewType(position)) {
                        R.layout.title_recyclerview-> 2
                        R.layout.featured_recyclerview-> 2
                        R.layout.top_picks_recyclerview-> 1
                        R.layout.trending_recyclerview-> 2
                        else -> 1
                    }
                }
            }
        }

        nftMultipleViewAdapter.itemClickListener = { view, item, position ->

            when(item) {
                is NftData.Title -> Toast.makeText(requireActivity(), "", Toast.LENGTH_SHORT).show()
                is NftData.Featured -> Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show()
                is NftData.Top -> Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show()
                is NftData.Trending -> Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show()
            }

        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                nftViewModel.nft.collect{ results ->
                    when (results) {
                        Resource.Loading ->  Toast.makeText(requireContext(), "Loading....",Toast.LENGTH_SHORT).show()
                        is Resource.Failure -> {
                            binding.imageViewAlert.visibility = View.VISIBLE
                            binding.textViewAlert1.visibility = View.VISIBLE
                            binding.textViewAlert2.visibility = View.VISIBLE
                        }
                        is Resource.Success -> {
                            binding.imageViewAlert.visibility = View.INVISIBLE
                            binding.textViewAlert1.visibility = View.INVISIBLE
                            binding.textViewAlert2.visibility = View.INVISIBLE
                            nftMultipleViewAdapter.submitList(results.value)
                        }
                        else -> {}
                    }

                }
            }
        }
    }
}