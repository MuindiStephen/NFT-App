/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.network

import okhttp3.ResponseBody

sealed class Resource<out T> {

    data class Success<out T>(val value: T) : Resource<T>()

    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ) : Resource<Nothing>()

    object Loading : Resource<Nothing>()

}