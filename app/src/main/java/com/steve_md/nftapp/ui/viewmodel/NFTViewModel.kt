/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.steve_md.nftapp.data.NftData
import com.steve_md.nftapp.data.repositories.NftRepository
import com.steve_md.nftapp.network.Resource
import com.steve_md.nftapp.utils.Constants.FEATURED_IMAGE
import com.steve_md.nftapp.utils.Constants.FEATURED_IMAGE_TITLE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NFTViewModel @Inject constructor(
    private val nftRepository: NftRepository
) : ViewModel() {

    private val _nft = MutableStateFlow<Resource<List<NftData>>>(Resource.Loading)
    val nft:StateFlow<Resource<List<NftData>>> = _nft

    init {
        getNft()
    }

    private fun getNft() = viewModelScope.launch {
        _nft.emit(Resource.Loading)
        val topNftDeferred = async { nftRepository.getTopNft() }   // without non blocking calls
        val trendingNftDeferred  = async { nftRepository.getTrendingNft() }   // without non blocking calls

        val topNft = topNftDeferred.await()
        val trendingNft = trendingNftDeferred.await()

        val nftList = mutableListOf<NftData>()

        if (topNft is Resource.Success && trendingNft is Resource.Success) {
            nftList.add(NftData.Title(1,"Featured", ""))
            nftList.add(NftData.Featured(FEATURED_IMAGE, FEATURED_IMAGE_TITLE))
            nftList.add(NftData.Title(2,"Top Pick", "View all"))
            nftList.addAll(topNft.value)
            nftList.add(NftData.Title(2, "Trending", ""))
            nftList.addAll(trendingNft.value)
            _nft.emit(Resource.Success(nftList))
        } else {
            Resource.Failure(false, null, null)
        }

    }


}