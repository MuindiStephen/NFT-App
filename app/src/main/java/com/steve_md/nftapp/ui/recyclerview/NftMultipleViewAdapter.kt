/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.ui.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.steve_md.nftapp.data.NftData

class NftMultipleViewAdapter : ListAdapter<NftData, NftMultipleViewHolder>(NftCallBack()) {
    class NftCallBack {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NftMultipleViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NftMultipleViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}