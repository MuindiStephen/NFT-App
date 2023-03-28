/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.data


sealed class NftData {

    class Title(
        val id: Int,
        val title: String,
        val viewAll: String,
    ) : NftData()

    class Featured(
        val image: String,
        val title: String
    ) : NftData()

    class Top(
        val id: Int,
        val image: String
    ) : NftData()

    class Trending(
        val id: Int,
        val image: String,
        val name: String,
        val category: String
    ) : NftData()

}