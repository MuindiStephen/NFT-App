/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.ui.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.steve_md.nftapp.data.NftData
import com.steve_md.nftapp.databinding.FeaturedRecyclerviewBinding
import com.steve_md.nftapp.databinding.TitleRecyclerviewBinding
import com.steve_md.nftapp.databinding.TopPicksRecyclerviewBinding
import com.steve_md.nftapp.databinding.TrendingRecyclerviewBinding
import com.steve_md.nftapp.utils.Constants.FEATURED_IMAGE
import com.steve_md.nftapp.utils.Constants.FEATURED_IMAGE_TITLE

sealed class NftMultipleViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    var itemClickListener: ((view:View, item:NftData, position:Int) -> Unit)? = null

    class TitleViewHolder(private val binding: TitleRecyclerviewBinding) : NftMultipleViewHolder(binding){
        fun bind(title: NftData.Title) {
            binding.txtFeatured.text = title.title
            binding.txtViewAll.text = title.viewAll
            binding.txtViewAll.setOnClickListener { view ->
                itemClickListener?.invoke(view, title, adapterPosition)
            }
        }
    }

    class FeaturedViewHolder(private val binding: FeaturedRecyclerviewBinding) : NftMultipleViewHolder(binding){
        fun bind(featured: NftData.Featured){
            binding.imgFeatured.load(FEATURED_IMAGE){
                crossfade(true)
                transformations(RoundedCornersTransformation(20F))
            }
            binding.imgFeatured.setOnClickListener {
                itemClickListener?.invoke(it, featured, adapterPosition)
            }
            binding.txtFeaturedTitle.text = FEATURED_IMAGE_TITLE
        }
    }

    class TopPicksViewHolder(private val binding: TopPicksRecyclerviewBinding) : NftMultipleViewHolder(binding){
        fun bind(topPicks: NftData.Top){
            binding.imgTopPicks.load(topPicks.image){
                crossfade(true)
                transformations(RoundedCornersTransformation(20F))
            }
            binding.imgTopPicks.setOnClickListener {
                itemClickListener?.invoke(it, topPicks, adapterPosition)
            }
        }
    }

    class TrendingViewHolder(private val binding: TrendingRecyclerviewBinding) : NftMultipleViewHolder(binding){
        fun bind(trending: NftData.Trending){

            binding.imgTrending.load(trending.image){
                crossfade(true)
                transformations(CircleCropTransformation())
            }

            binding.topNftLayout.setOnClickListener { view ->
                itemClickListener?.invoke(view, trending, adapterPosition)
            }

            binding.txtNftTitle.text = trending.name
            binding.txtCategory.text = trending.category
        }
    }

}
