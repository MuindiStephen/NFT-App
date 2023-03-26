/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.network

import javax.inject.Inject

class ApiDataSource @Inject constructor(
   private val apiService: NftApiService
) {
    suspend fun getTopNft() =  apiService.getTopNft()
    suspend fun getTrendingNft() = apiService.getTrendingNft()
}