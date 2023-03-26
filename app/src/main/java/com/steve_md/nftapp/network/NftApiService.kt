/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.network

import com.steve_md.nftapp.data.NftData
import com.steve_md.nftapp.utils.Constants.TOP_NFT
import retrofit2.http.GET

interface NftApiService{
    @GET(TOP_NFT)
    suspend fun getTopNft() : List<NftData.Top>

    @GET()
    suspend fun getTrendingNft(): List<NftData.Trending>
}