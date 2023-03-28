/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.ui.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.steve_md.nftapp.R
import com.steve_md.nftapp.data.NftData
import com.steve_md.nftapp.databinding.FeaturedRecyclerviewBinding
import com.steve_md.nftapp.databinding.TitleRecyclerviewBinding
import com.steve_md.nftapp.databinding.TopPicksRecyclerviewBinding
import com.steve_md.nftapp.databinding.TrendingRecyclerviewBinding


/**
 * @This adapter extends @[ListAdapter] :)
 *
 */
class NftMultipleViewAdapter : ListAdapter<NftData, NftMultipleViewHolder>(NftCallBack()) {
    class NftCallBack : DiffUtil.ItemCallback<NftData>() {
        override fun areItemsTheSame(oldItem: NftData, newItem: NftData): Boolean {
            return when {
                oldItem is NftData.Top && newItem is NftData.Top -> {
                    oldItem.id == newItem.id
                }
                oldItem is NftData.Trending && newItem is NftData.Trending -> {
                    oldItem.id == newItem.id
                }
                else -> {
                    false
                }
            }
        }

        override fun areContentsTheSame(oldItem: NftData, newItem: NftData): Boolean {
            return when {
                oldItem is NftData.Top && newItem is NftData.Top -> {
                    oldItem == newItem
                }

                oldItem is NftData.Trending && newItem is NftData.Trending -> {
                    oldItem == newItem
                }
                else -> {false}
            }
        }

    }

     var itemClickListener:((view:View, item:NftData, position:Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NftMultipleViewHolder {
        return when(viewType){
            R.layout.title_recyclerview -> NftMultipleViewHolder.TitleViewHolder(
                TitleRecyclerviewBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            R.layout.featured_recyclerview -> NftMultipleViewHolder.FeaturedViewHolder(
                FeaturedRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false
                )
            )
            R.layout.top_picks_recyclerview-> NftMultipleViewHolder.TopPicksViewHolder(
                 TopPicksRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false
                )
            )
            R.layout.trending_recyclerview -> NftMultipleViewHolder.TrendingViewHolder(
                TrendingRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false
                )
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: NftMultipleViewHolder, position: Int) {

        holder.itemClickListener = itemClickListener

        val item = getItem(position)
        when(holder){
            is NftMultipleViewHolder.FeaturedViewHolder -> holder.bind(item as NftData.Featured)
            is NftMultipleViewHolder.TitleViewHolder -> holder.bind(item as NftData.Title)
            is NftMultipleViewHolder.TopPicksViewHolder -> holder.bind(item as NftData.Top)
            is NftMultipleViewHolder.TrendingViewHolder -> holder.bind(item as NftData.Trending)
        }
    }

}