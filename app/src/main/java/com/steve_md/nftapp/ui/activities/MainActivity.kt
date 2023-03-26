/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.steve_md.nftapp.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}