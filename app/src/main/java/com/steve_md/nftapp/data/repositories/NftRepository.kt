/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.data.repositories

import com.steve_md.nftapp.network.ApiDataSource
import com.steve_md.nftapp.network.SafeApiCall
import javax.inject.Inject

class NftRepository @Inject constructor(
    private val dataSource: ApiDataSource
) : SafeApiCall {
    suspend fun getTopNft() = safeApiCall { dataSource.getTopNft() }
    suspend fun getTrendingNft() = safeApiCall { dataSource.getTrendingNft() }
}